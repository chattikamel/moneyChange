package io.projects.moneychange.model;

import javafx.util.Pair;

public class ChangePair extends Pair<Long, Change> {


    public ChangePair(long amount) {
        super(amount, new Change());
    }

    public ChangePair(Long amount, Change change) {
        super(amount, change);
    }

    public Long getAmount() {
        return getKey();
    }

    public Change getChange() {
        return getValue();
    }
}
