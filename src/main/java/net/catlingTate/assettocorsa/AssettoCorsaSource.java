package net.catlingTate.assettocorsa;

import net.catlingTate.base.STKSessionInfo;
import net.catlingTate.base.STKSource;
import net.catlingTate.error.STKIOError;
import net.catlingTate.error.STKNetworkError;

public class AssettoCorsaSource implements STKSource {
    public final String SOURCE_NAME = "assetto corsa";

    private final AssettoCorsaUDPTelemetryHandler udpHandler;

    public AssettoCorsaSource() throws STKNetworkError {
        udpHandler = new AssettoCorsaUDPTelemetryHandler();
    }

    public void start() throws STKIOError {
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
