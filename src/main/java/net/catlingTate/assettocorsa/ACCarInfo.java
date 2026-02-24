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
public class ACCarInfo {
    @Getter
    private Integer id;
    @Getter
    private Integer size;

    @Getter
    private Float speedKmh;
    @Getter
    private Float speedMph;
    @Getter
    private Float speedMs;

    /* Booleans are transmitted as unsigned 8-bit ints */
    @Getter
    private Boolean absEnabled;
    @Getter
    private Boolean absAction;
    @Getter
    private Boolean tcAction;
    @Getter
    private Boolean tcEnabled;
    @Getter
    private Boolean inPit;
    @Getter
    private Boolean engineLimiter;

    /* Skip 2 bytes here */

    @Getter
    private Float accGVertical;
    @Getter
    private Float accGHorizontal;
    @Getter
    private Float accGFrontal;

    @Getter
    private Integer lapTime;
    @Getter
    private Integer lastLap;
    @Getter
    private Integer bestLap;
    @Getter
    private Integer lapCount;

    @Getter
    private Float gas;
    @Getter
    private Float brake;
    @Getter
    private Float clutch;
    @Getter
    private Float engineRpm;
    @Getter
    private Float steer;
    @Getter
    private Integer gear;

    @Getter
    private Float cgHeight;

    @Getter
    private Float angularSpeedWheel1;
    @Getter
    private Float angularSpeedWheel2;
    @Getter
    private Float angularSpeedWheel3;
    @Getter
    private Float angularSpeedWheel4;

    @Getter
    private Float slipAngleWheel1;
    @Getter
    private Float slipAngleWheel2;
    @Getter
    private Float slipAngleWheel3;
    @Getter
    private Float slipAngleWheel4;

    @Getter
    private Float slipAngleContactPatchWheel1;
    @Getter
    private Float slipAngleContactPatchWheel2;
    @Getter
    private Float slipAngleContactPatchWheel3;
    @Getter
    private Float slipAngleContactPatchWheel4;

    @Getter
    private Float slipRatioWheel1;
    @Getter
    private Float slipRatioWheel2;
    @Getter
    private Float slipRatioWheel3;
    @Getter
    private Float slipRatioWheel4;

    @Getter
    private Float tireSlipWheel1;
    @Getter
    private Float tireSlipWheel2;
    @Getter
    private Float tireSlipWheel3;
    @Getter
    private Float tireSlipWheel4;

    @Getter
    private Float loadWheel1;
    @Getter
    private Float loadWheel2;
    @Getter
    private Float loadWheel3;
    @Getter
    private Float loadWheel4;

    @Getter
    private Float dyWheel1;
    @Getter
    private Float dyWheel2;
    @Getter
    private Float dyWheel3;
    @Getter
    private Float dyWheel4;

    @Getter
    private Float mzWheel1;
    @Getter
    private Float mzWheel2;
    @Getter
    private Float mzWheel3;
    @Getter
    private Float mzWheel4;

    @Getter
    private Float tireDirtyLevelWheel1;
    @Getter
    private Float tireDirtyLevelWheel2;
    @Getter
    private Float tireDirtyLevelWheel3;
    @Getter
    private Float tireDirtyLevelWheel4;

    @Getter
    private Float tireRadiusWheel1;
    @Getter
    private Float tireRadiusWheel2;
    @Getter
    private Float tireRadiusWheel3;
    @Getter
    private Float tireRadiusWheel4;

    @Getter
    private Float tireLoadedRadiusWheel1;
    @Getter
    private Float tireLoadedRadiusWheel2;
    @Getter
    private Float tireLoadedRadiusWheel3;
    @Getter
    private Float tireLoadedRadiusWheel4;

    @Getter
    private Float suspensionHeightWheel1;
    @Getter
    private Float suspensionHeightWheel2;
    @Getter
    private Float suspensionHeightWheel3;
    @Getter
    private Float suspensionHeightWheel4;

    /* Zero to One, indicating to start to finish */
    @Getter
    private Float carPositionNormalized;

    @Getter
    private Float carSlope;

    @Getter
    private Float carPositionX;
    @Getter
    private Float carPositionY;
    @Getter
    private Float carPositionZ;

    public ACCarInfo(byte[] bufferData) {
        ByteBuffer buffer = ByteBuffer.wrap(bufferData).order(ByteOrder.LITTLE_ENDIAN);

        id = buffer.getInt();
        size = buffer.getInt();

        speedKmh = buffer.getFloat();
        speedMph = buffer.getFloat();
        speedMs = buffer.getFloat();

        absEnabled = buffer.get() == 1;
        absAction = buffer.get() == 1;
        tcEnabled = buffer.get() == 1;
        inPit = buffer.get() == 1;
        engineLimiter = buffer.get() == 1;

        /* Skip 2 bytes */
        buffer.get();
        buffer.get();

        accGVertical = buffer.getFloat();
        accGHorizontal = buffer.getFloat();
        accGFrontal = buffer.getFloat();

        lapTime = buffer.getInt();
        lastLap = buffer.getInt();
        bestLap = buffer.getInt();
        lapCount = buffer.getInt();

        gas = buffer.getFloat();
        brake = buffer.getFloat();
        clutch = buffer.getFloat();
        engineRpm = buffer.getFloat();
        steer = buffer.getFloat();
        gear = buffer.getInt();

        cgHeight = buffer.getFloat();

        angularSpeedWheel1 = buffer.getFloat();
        angularSpeedWheel2 = buffer.getFloat();
        angularSpeedWheel3 = buffer.getFloat();
        angularSpeedWheel4 = buffer.getFloat();

        slipAngleWheel1 = buffer.getFloat();
        slipAngleWheel2 = buffer.getFloat();
        slipAngleWheel3 = buffer.getFloat();
        slipAngleWheel4 = buffer.getFloat();

        slipAngleContactPatchWheel1 = buffer.getFloat();
        slipAngleContactPatchWheel2 = buffer.getFloat();
        slipAngleContactPatchWheel3 = buffer.getFloat();
        slipAngleContactPatchWheel4 = buffer.getFloat();

        slipRatioWheel1 = buffer.getFloat();
        slipRatioWheel2 = buffer.getFloat();
        slipRatioWheel3 = buffer.getFloat();
        slipRatioWheel4 = buffer.getFloat();

        tireSlipWheel1 = buffer.getFloat();
        tireSlipWheel2 = buffer.getFloat();
        tireSlipWheel3 = buffer.getFloat();
        tireSlipWheel4 = buffer.getFloat();

        loadWheel1 = buffer.getFloat();
        loadWheel2 = buffer.getFloat();
        loadWheel3 = buffer.getFloat();
        loadWheel4 = buffer.getFloat();

        dyWheel1 = buffer.getFloat();
        dyWheel2 = buffer.getFloat();
        dyWheel3 = buffer.getFloat();
        dyWheel4 = buffer.getFloat();

        mzWheel1 = buffer.getFloat();
        mzWheel2 = buffer.getFloat();
        mzWheel3 = buffer.getFloat();
        mzWheel4 = buffer.getFloat();

        tireDirtyLevelWheel1 = buffer.getFloat();
        tireDirtyLevelWheel2 = buffer.getFloat();
        tireDirtyLevelWheel3 = buffer.getFloat();
        tireDirtyLevelWheel4 = buffer.getFloat();

        tireRadiusWheel1 = buffer.getFloat();
        tireRadiusWheel2 = buffer.getFloat();
        tireRadiusWheel3 = buffer.getFloat();
        tireRadiusWheel4 = buffer.getFloat();

        tireLoadedRadiusWheel1 = buffer.getFloat();
        tireLoadedRadiusWheel2 = buffer.getFloat();
        tireLoadedRadiusWheel3 = buffer.getFloat();
        tireLoadedRadiusWheel4 = buffer.getFloat();

        suspensionHeightWheel1 = buffer.getFloat();
        suspensionHeightWheel2 = buffer.getFloat();
        suspensionHeightWheel3 = buffer.getFloat();
        suspensionHeightWheel4 = buffer.getFloat();

        carPositionNormalized = buffer.getFloat();
        carSlope = buffer.getFloat();
        carPositionX = buffer.getFloat();
        carPositionY = buffer.getFloat();
        carPositionZ = buffer.getFloat();
    }
}
