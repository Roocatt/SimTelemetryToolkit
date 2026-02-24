package net.catlingTate.iracing;

import net.catlingTate.base.STKSessionInfo;
import net.catlingTate.base.STKSource;
import net.catlingTate.error.STKNetworkError;

import java.io.IOException;

public class IRacingSource implements STKSource {


    public IRacingSource() {

    }

    @Override
    public STKSessionInfo sessionInfo() {
        return null;
    }

    @Override
    public void start() throws STKNetworkError {

    }

    @Override
    public void close() throws IOException {

    }
}
