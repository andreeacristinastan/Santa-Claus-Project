package assignsortstrategy;

import common.Constants;

public final class AssignGiftsSortFactory {
    private static AssignGiftsSortFactory instance = null;

    private AssignGiftsSortFactory() {

    }

    /**
     * Metoda ce ajuta la crearea singletonului.
     * @return - instanta clasei.
     */

    public static AssignGiftsSortFactory getInstance() {
        if (instance == null) {
            instance = new AssignGiftsSortFactory();
        }

        return instance;
    }

    /**
     * Metoda verifica strategia dupa care se vor acorda cadouri in runda
     * curenta si apeleaza metoda corespunzatoare pentru fiecare caz in
     * parte.
     * @param strategy - tipul strategiei de distributie a cadourilor din
     *                 anul curent.
     * @return - rezultatul strategiei apelate pentru a sorta lista de copii.
     */
    public AssignGiftsSortStrategy createAssignGifts(final String strategy) {
        return switch (strategy) {
            case Constants.ID_STRATEGY -> new IdSort();
            case Constants.NICE_SCORE_STRATEGY -> new NiceScoreSort();
            case Constants.NICE_SCORE_CITY_STRATEGY -> new NiceScoreCitySort();
            default -> null;
        };
    }
}
