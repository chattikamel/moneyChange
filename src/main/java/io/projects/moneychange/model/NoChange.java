package io.projects.moneychange.model;

public class NoChange extends Change {

    public static NoChange NoCHANGE = new NoChange();

    private NoChange()
    {
        super();
    }


    @Override
    public boolean isPossible() {
        return false;
    }
}
