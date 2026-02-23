package net.catlingTate.base;

import net.catlingTate.error.STKNetworkError;

import java.io.Closeable;

public interface STKBaseSource extends Closeable {
    STKSessionInfo sessionInfo();
    void start() throws STKNetworkError;
}
