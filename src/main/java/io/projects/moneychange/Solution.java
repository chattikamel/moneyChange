package io.projects.moneychange;

import io.projects.moneychange.model.Change;

public class Solution {
    public static Change optimalChange(long s) {
        return  Change.builder().coin2(s/2).build();
    }
}
