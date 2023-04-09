package jsonwriter;

import java.util.ArrayList;

public final class AnnualChildren {
    private ArrayList<Children> annualChildren;

    public ArrayList<Children> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(final ArrayList<Children> annualChildren) {
        this.annualChildren = new ArrayList<>(annualChildren);
    }
}
