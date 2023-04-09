package init;

import java.util.ArrayList;

public final class DataInit {
    private ArrayList<ChildrenInit> children;
    private ArrayList<SantaGiftsListInit> santaGifts;

    public ArrayList<ChildrenInit> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildrenInit> children) {
        this.children = new ArrayList<>(children);
    }

    public ArrayList<SantaGiftsListInit> getSantaGiftsList() {
        return santaGifts;
    }

    public void setSantaGiftsList(final ArrayList<SantaGiftsListInit> gifts) {
        this.santaGifts = gifts;
    }
}
