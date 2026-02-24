package net.catlingTate.base;

import net.catlingTate.error.STKIOError;

import java.io.Closeable;

public interface TelemetryHandler extends Closeable {
    void connect() throws STKIOError;
}
