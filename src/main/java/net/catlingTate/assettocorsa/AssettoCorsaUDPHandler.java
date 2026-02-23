package net.catlingTate.assettocorsa;

import net.catlingTate.base.UDPHandler;
import net.catlingTate.error.STKNetworkError;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AssettoCorsaUDPHandler extends UDPHandler {
    public AssettoCorsaUDPHandler() throws STKNetworkError {
        super(UDPHandler.getLocalhost(), UDPHandler.AC_PORT);
    }

    @Override
    protected void setup() throws STKNetworkError {
        send(buildMessage(ACOperationID.HANDSHAKE));
    }

    @Override
    protected void cleanup() {
        try {
            send(buildMessage(ACOperationID.DISMISS));
        } catch (STKNetworkError e) {} /* Ignore exception as it is on cleanup anyway */
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