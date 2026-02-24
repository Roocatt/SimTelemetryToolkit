package net.catlingTate.base;

import net.catlingTate.error.STKIOError;

import java.io.Closeable;

public interface STKSource extends Closeable {
    STKSessionInfo sessionInfo();
    void start() throws STKIOError;
}
