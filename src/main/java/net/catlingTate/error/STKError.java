package net.catlingTate.error;

import java.net.SocketException;

public class STKError extends Exception {
    public STKError(Exception e) {
        super(e);
    }
}
