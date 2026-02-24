package net.catlingTate.iracing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
class IRacingIBTVarHeader {
    @Getter
    private Integer varType;
    @Getter
    private Integer offset;
    @Getter
    private Integer varCount;
}
