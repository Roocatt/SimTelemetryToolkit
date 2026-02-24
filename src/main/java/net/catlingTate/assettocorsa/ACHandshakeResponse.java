package net.catlingTate.assettocorsa;

import lombok.Getter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class ACHandshakeResponse {
    private static final int STR_LEN = 100;
    public static final int TOTAL_LEN = STR_LEN * 4 + Integer.BYTES * 2;

    @Getter
    private final String carName;

    @Getter
    private final String driverName;

    @Getter
    private final Integer id;

    @Getter
    private final Integer version;

    @Getter
    private final String trackName;

    @Getter
    private final String trackConfig;

    public ACHandshakeResponse(byte[] bufferData) {
        ByteBuffer buffer = ByteBuffer.wrap(bufferData).order(ByteOrder.LITTLE_ENDIAN);
        byte[] strBuffer = new byte[STR_LEN];

        buffer.get(strBuffer, 0, STR_LEN);
        carName = new String(strBuffer);

        buffer.get(strBuffer, 0, STR_LEN);
        driverName = new String(strBuffer);

        id = buffer.getInt();
        version = buffer.getInt();

        buffer.get(strBuffer, 0, STR_LEN);
        trackName = new String(strBuffer);

        buffer.get(strBuffer, 0, STR_LEN);
        trackConfig = new String(strBuffer);
    }
}
