package net.catlingTate.iracing;

import net.catlingTate.base.FileTelemetryHandler;
import net.catlingTate.error.STKFileError;
import net.catlingTate.error.STKNetworkError;

import java.io.FileInputStream;

public class IRacingTelemetryHandler extends FileTelemetryHandler {
    FileInputStream reader;

    public IRacingTelemetryHandler(String filename) throws STKFileError {
        super(filename);
    }

    @Override
    protected void setup() throws STKNetworkError {

    }

    @Override
    protected void cleanup() {
    }
}
