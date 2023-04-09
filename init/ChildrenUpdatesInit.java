package init;

import java.util.ArrayList;

public final class ChildrenUpdatesInit {
    private int id;
    private Double niceScore;
    private ArrayList<String> giftsPreferences;
    private String elf;

    public String getElf() {
        return elf;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
    }
}
