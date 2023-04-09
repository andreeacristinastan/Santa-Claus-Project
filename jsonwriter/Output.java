package jsonwriter;

import receivegifts.ReceivedGift;

import java.util.ArrayList;

public final class Output {

    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final String city;
    private final int age;
    private final ArrayList<String> giftsPreferences;
    private final double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private final double assignedBudget;
    private final ArrayList<ReceivedGift> receivedGifts;

    public static final class Builder {
        private final Integer id;
        private final String lastName;
        private final String firstName;
        private final String city;
        private final int age;
        private final ArrayList<String> giftsPreferences;
        private final double averageScore;
        private final ArrayList<Double> niceScoreHistory;
        private final double assignedBudget;
        private final ArrayList<ReceivedGift> receivedGifts;

        public Builder(final Integer id, final String lastName,
                       final String firstName, final String city,
                       final int age, final ArrayList<String> giftsPreferences,
                       final double averageScore, final ArrayList<Double> niceScoreHistory,
                       final double assignedBudget, final ArrayList<ReceivedGift> receivedGifts) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.giftsPreferences = new ArrayList<>(giftsPreferences);
            this.niceScoreHistory = new ArrayList<>(niceScoreHistory);
            this.averageScore = averageScore;
            this.assignedBudget = assignedBudget;
            this.receivedGifts = new ArrayList<>(receivedGifts);
        }

        /**
         * Metoda ce construieste o noua instanta a clasei Output si o returneaza.
         * @return - instanta clasei Output creata.
         */
        public Output build() {
            return new Output(this);
        }
    }

    private Output(final Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.giftsPreferences = builder.giftsPreferences;
        this.niceScoreHistory = builder.niceScoreHistory;
        this.averageScore = builder.averageScore;
        this.assignedBudget = builder.assignedBudget;
        this.receivedGifts = builder.receivedGifts;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public double getAssignedBudget() {
        return assignedBudget;
    }

    public ArrayList<ReceivedGift> getReceivedGifts() {
        return receivedGifts;
    }
}
