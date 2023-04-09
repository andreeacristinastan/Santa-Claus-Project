package init;

import receivegifts.ReceivedGift;

import java.util.ArrayList;

public final class ChildrenInit {
    private Integer id;
    private String lastName;
    private String firstName;
    private int age;
    private String city;
    private Double niceScore;
    private Double average = 0.0;
    private Double assignedBudget = 0.0;
    private String elf;
    private Double niceScoreBonus = 0.0;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private ArrayList<String> giftsPreferences = new ArrayList<>();
    private ArrayList<ReceivedGift> receivedGifts = new ArrayList<>();

    public String getElf() {
        return elf;
    }

    public void setElf(final String elf) {
        this.elf = elf;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void setReceivedGifts(final ArrayList<ReceivedGift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public ArrayList<ReceivedGift> getReceivedGifts() {
        return receivedGifts;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(final double average) {
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
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
        this.giftsPreferences = giftsPreferences;
    }
}
