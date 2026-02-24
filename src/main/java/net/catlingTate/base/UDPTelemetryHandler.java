package net.catlingTate.base;

import net.catlingTate.error.STKIOError;
import net.catlingTate.error.STKNetworkError;

import java.io.Closeable;
import java.io.IOException;
import java.net.*;

public abstract class UDPTelemetryHandler implements TelemetryHandler {
    public static final int AC_PORT = 9996;


    private final InetAddress inetAddress;
    private final int port;
    private DatagramSocket socket;
    private boolean isClosed;

    public UDPTelemetryHandler(InetAddress inetAddress, int port) {
        this.inetAddress = inetAddress;
        this.port = port;
        isClosed = true;
    }

    public void connect() throws STKIOError {
        try {
            socket = new DatagramSocket();
            socket.connect(inetAddress, port);
            isClosed = false;

            setup();
        } catch (SocketException e) {
            throw new STKNetworkError(e);
        }
    }

    public void close() {
        cleanup();
        isClosed = true;
        socket.close();
    }

    protected void send(byte[] buffer) throws STKNetworkError {
        try {
            socket.send(new DatagramPacket(buffer, buffer.length));
        } catch (IOException e) {
            throw new STKNetworkError(e);
        }
    }

    protected byte[] receive(int dataLen) throws STKNetworkError {
        DatagramPacket receivePacket;
        byte[] buffer = new byte[1024];

        receivePacket = new DatagramPacket(buffer, dataLen);
        try {
            socket.receive(receivePacket);
        } catch (IOException ex) {
            throw new STKNetworkError(ex);
        }

        return buffer;
    }

    protected abstract void setup() throws STKNetworkError;
    protected abstract void cleanup();

    protected static InetAddress getLocalhost() throws STKNetworkError {
        try {
            return InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new STKNetworkError(e);
        }
    }
}
