package net.catlingTate.assettocorsa;

import net.catlingTate.base.STKSessionInfo;
import net.catlingTate.base.STKBaseSource;
import net.catlingTate.error.STKNetworkError;

public class AssettoCorsaSource implements STKBaseSource {
    public final String SOURCE_NAME = "assetto corsa";

    private final AssettoCorsaUDPHandler udpHandler;

    public AssettoCorsaSource() throws STKNetworkError {
        udpHandler = new AssettoCorsaUDPHandler();
    }

    public void start() throws STKNetworkError {
        udpHandler.connect();
    }

    @Override
    public void close() {
        udpHandler.close();
    }

    public STKSessionInfo sessionInfo() {
        ACHandshakeResponse acHandshakeResponse = udpHandler.getHandshakeResponse();
        return STKSessionInfo.builder()
                .driver(acHandshakeResponse.getDriverName())
                .car(acHandshakeResponse.getCarName())
                .track(acHandshakeResponse.getTrackName() + ": " + acHandshakeResponse.getTrackConfig())
                .source(SOURCE_NAME)
                .build();
    }
}
