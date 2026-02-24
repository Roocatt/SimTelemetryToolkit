package net.catlingTate.base;

import net.catlingTate.error.STKFileError;
import net.catlingTate.error.STKIOError;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class FileTelemetryHandler implements TelemetryHandler {
    private FileInputStream reader;
    private String filename;
    private boolean isClosed;

    public FileTelemetryHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void connect() throws STKIOError {
        try {
            reader = new FileInputStream(filename);
        } catch (IOException e) {
            throw new STKFileError(e);
        }

        isClosed = false;
        setup();
    }

    public void close() {
        cleanup();
        isClosed = true;
    }

    protected abstract void setup() throws STKIOError;
    protected abstract void cleanup();
}
