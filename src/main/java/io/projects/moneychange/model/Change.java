package io.projects.moneychange.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Change {

    private long coin2 = 0;

    private long bill5 = 0;

    private long bill10 = 0;
}
