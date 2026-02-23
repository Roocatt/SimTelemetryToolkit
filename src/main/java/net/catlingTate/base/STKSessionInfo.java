package net.catlingTate.base;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class STKSessionInfo {
    @Getter
    @Setter
    private String driver;

    @Getter
    @Setter
    private String car;

    @Getter
    @Setter
    private String track;

    @Getter
    @Setter
    private String source;
}
