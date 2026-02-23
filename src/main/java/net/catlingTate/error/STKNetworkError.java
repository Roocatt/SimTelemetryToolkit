package net.catlingTate.error;

import java.io.IOException;

public class STKNetworkError extends STKError {
    public STKNetworkError(IOException e) {
        super(e);
    }
}
