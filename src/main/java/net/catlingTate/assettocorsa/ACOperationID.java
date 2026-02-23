package net.catlingTate.assettocorsa;

public enum ACOperationID {
    HANDSHAKE(0),
    SUBSCRIBE_UPDATE(1),
    SUBSCRIBE_SPOT(2),
    DISMISS(3);

    private final int code;

    ACOperationID(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
