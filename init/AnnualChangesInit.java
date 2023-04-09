package init;

import java.util.ArrayList;

public final class AnnualChangesInit {
    private double newSantaBudget;
    private ArrayList<SantaGiftsListInit> newGifts;
    private ArrayList<ChildrenInit> newChildren;
    private ArrayList<ChildrenUpdatesInit> childrenUpdatesInit;
    private String strategy;

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<SantaGiftsListInit> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<SantaGiftsListInit> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<ChildrenInit> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<ChildrenInit> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<ChildrenUpdatesInit> getChildrenUpdates() {
        return childrenUpdatesInit;
    }

    public void setChildrenUpdates(final ArrayList<ChildrenUpdatesInit> childrenUpdates) {
        this.childrenUpdatesInit = childrenUpdates;
    }
}
