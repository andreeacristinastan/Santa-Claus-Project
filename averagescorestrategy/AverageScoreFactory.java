package averagescorestrategy;


import common.Constants;

public final class AverageScoreFactory {

    private static AverageScoreFactory instance = null;

    private AverageScoreFactory() {

    }

    /**
     * Metoda ce ajuta la crearea singletonului.
     * @return - instanta clasei.
     */

    public static AverageScoreFactory getInstance() {
        if (instance == null) {
            instance = new AverageScoreFactory();
        }

        return instance;
    }

    /**
     * Metoda verifica in ce categorie de varsta se afla fiecare copil si apeleaza
     * strategia corespunzatoare de calculare a averageScore-ului anual.
     * @param age - varsta copilului.
     * @return - rezultatul strategiei apelate pentru a afla average score-ul.
     */
    public AverageScoreStrategy createAverageScore(final Integer age) {
        if (age < Constants.AGE_LIMIT_LITTLE) {
            return new BabyAverageScore();
        } else if (age < Constants.AGE_LIMIT_MEDIUM) {
            return new KidAverageScore();
        } else if (age <= Constants.AGE_LIMIT) {
            return new TeenAverageScore();
        }
        return null;
    }
}
