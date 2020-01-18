package io.projects.moneychange;

import io.projects.moneychange.model.Change;

public class Solution {
    public static Change optimalChange(long s) {
        if (s % 10 == 0)
            return Change.builder().bill10(s / 10).build();
        else if (s % 5 == 0)
            return Change.builder().bill5(s / 5).build();
        else if (s % 2 == 0)
            return Change.builder().coin2(s / 2).build();

        return Change.builder().build();
    }
}
