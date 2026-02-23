package net.catlingTate.assettocorsa;

import lombok.Getter;

enum ACOperationID {
    HANDSHAKE(0),
    SUBSCRIBE_UPDATE(1),
    SUBSCRIBE_SPOT(2),
    DISMISS(3);

    @Getter
    private final int code;

    ACOperationID(int code) {
        this.code = code;
    }
}
