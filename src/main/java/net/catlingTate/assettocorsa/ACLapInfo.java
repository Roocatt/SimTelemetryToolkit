package net.catlingTate.assettocorsa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ACLapInfo {
    private static final int STR_LEN = 100;

    @Getter
    private Integer carIdNumber;
    @Getter
    private Integer lap;
    @Getter
    private String driverName;
    @Getter
    private String carName;
    @Getter
    private Integer time;

    public ACLapInfo(byte[] bufferData) {
        ByteBuffer buffer = ByteBuffer.wrap(bufferData).order(ByteOrder.LITTLE_ENDIAN);
        byte[] strBuffer = new byte[STR_LEN];

        carIdNumber = buffer.getInt();
        lap = buffer.getInt();

        buffer.get(strBuffer, 0, STR_LEN);
        driverName = new String(strBuffer);

        buffer.get(strBuffer, 0, STR_LEN);
        carName = new String(strBuffer);

        time = buffer.getInt();
    }
}
