package jsonwriter;

import java.util.ArrayList;

public final class Children {
    private ArrayList<Output> children;

    public ArrayList<Output> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<Output> children) {
        this.children = new ArrayList<>(children);
    }

}
