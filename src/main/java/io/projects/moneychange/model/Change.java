package io.projects.moneychange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Change implements Changeable{

    private long coin2 = 0;

    private long bill5 = 0;

    private long bill10 = 0;

    public long sum() {
        return coin2 * 2 + bill5 * 5 + bill10 * 10;
    }

    @Override
    public boolean isPossible() {
        return true;
    }
}
