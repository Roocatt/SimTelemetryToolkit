package net.catlingTate.assettocorsa;

import net.catlingTate.base.UDPHandler;
import net.catlingTate.error.STKNetworkError;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class AssettoCorsaUDPHandler extends UDPHandler {
    private ACHandshakeResponse handshakeResponse;

    public AssettoCorsaUDPHandler() throws STKNetworkError {
        super(UDPHandler.getLocalhost(), UDPHandler.AC_PORT);
    }

    @Override
    protected void setup() throws STKNetworkError {
        byte[] handshakeResponseBuffer;

        send(buildMessage(ACOperationID.HANDSHAKE));
        handshakeResponseBuffer = receive(ACHandshakeResponse.TOTAL_LEN);
        handshakeResponse = new ACHandshakeResponse(handshakeResponseBuffer);
    }

    @Override
    protected void cleanup() {
        try {
            send(buildMessage(ACOperationID.DISMISS));
        } catch (STKNetworkError _) {} /* Ignore exception as it is on cleanup anyway */
    }

    protected ACHandshakeResponse getHandshakeResponse() {
        return handshakeResponse;
    }

    private byte[] buildMessage(ACOperationID op) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES * 3);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(op.getCode());

        return buffer.array();
    }
}