package io.projects.moneychange;

import io.projects.moneychange.model.Change;
import io.projects.moneychange.model.ChangePair;
import io.projects.moneychange.model.NoChange;

import java.util.function.Function;

public class Solution {

    static Function<Function<ChangePair, ChangePair>, Function<ChangePair, ChangePair>> _changeWith = Solution::changeWith;

    public static Change optimalChange(long s) {
        return _changeWith.apply(Solution::noChange)
                .compose(_changeWith.apply(Solution::changeWith5Bill))
                .compose(Solution::changeWith10Bill)
                .apply(new ChangePair(s))
                .getChange();

//        return changeWith(
//                changeWith(
//                        changeWith(new ChangePair(s, new Change()),
//                                Solution::changeWith10Bill),
//                        Solution::changeWith5Bill),
//                Solution::noChange)
//                .getChange();
//
//
    }


    protected static ChangePair changeWith10Bill(ChangePair p) {
        return new ChangePair(p.getAmount() % 10, cloneChange(p.getChange()).bill10(p.getAmount() / 10).build());
    }

    protected static ChangePair changeWith5Bill(ChangePair p) {
        return new ChangePair(p.getAmount() % 5, cloneChange(p.getChange()).bill5(p.getAmount() / 5).build());
    }

    protected static ChangePair changeWith2Coin(ChangePair p) {
        return new ChangePair(p.getAmount() % 2, cloneChange(p.getChange()).coin2(p.getAmount() / 2).build());
    }

    protected static ChangePair noChange(ChangePair p) {
        return new ChangePair(0l, NoChange.NoCHANGE);
    }

    protected static Function<ChangePair, ChangePair> changeWith(Function<ChangePair, ChangePair> f) {
        return p -> {
            if (p.getAmount() > 0)
                return p.getAmount() < 10 && p.getAmount() % 2 == 0 ?
                        changeWith2Coin(p) :
                        f.apply(p);

            return p;
        };
    }

    protected static Change.ChangeBuilder cloneChange(Change change) {
        return Change.builder()
                .bill10(change.getBill10())
                .bill5(change.getBill5())
                .coin2(change.getCoin2());
    }
}
