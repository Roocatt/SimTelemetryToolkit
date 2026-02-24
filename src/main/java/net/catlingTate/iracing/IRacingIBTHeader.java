package net.catlingTate.iracing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
class IRacingIBTHeader {
    @Getter
    private Integer version;
    @Getter
    private Integer status;
    @Getter
    private Integer tickRate;

    @Getter
    private Integer sessionInfoUpdate;
    @Getter
    private Integer sessionInfoLen;
    @Getter
    private Integer sessionInfoOffset;

    @Getter
    private Integer numVars;
    @Getter
    private Integer varHeaderOffset;

    /* TODO Finish this class */
}
