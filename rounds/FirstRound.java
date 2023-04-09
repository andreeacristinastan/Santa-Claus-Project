package rounds;

import assignsortstrategy.AssignGiftsSortFactory;
import assignsortstrategy.AssignGiftsSortStrategy;
import common.Constants;
import init.ChildrenInit;
import init.InputLoader;
import receivegifts.GiftCategory;
import averagescorestrategy.AverageScoreFactory;
import averagescorestrategy.AverageScoreStrategy;
import yellowelfassign.YellowGiftsAssign;

import java.util.ArrayList;

public final class FirstRound {
    private FirstRound() {
    }

    /**
     * Metoda se ocupa cu pregatirea tuturor elementelor necesare
     * pentru inceperea fiecarei runde in parte.
     * Initial, se va determina averageScore-ul pentru fiecare copil
     * folosindu-ne de designPattern-ul Strategy si Factory.
     * Apoi, se va calcula budget unit-ul care va sta la baza calcularii
     * bugetului alocat pentru fiecare copil in parte de catre mos Craciun.
     * Inainte de distribuirea efectiva a cadourilor, este apelata metoda
     * corespunzatoare pentru sortare a listei de copii, in functie de tipul
     * strategiei aplicate rundei curente (daca aceasta nu este runda 0).
     * Dupa ce toate elementele necesare sunt setate, se incepe distribuirea
     * cadourilor prin apelarea metodelor specifice, in final relaizandu-se
     * distribuirea caodurilor pentru copiii cu elf galben.
     * @param inputLoader - baza de date initiala.
     * @param pos - variabila ce retine numarul rundei ce se efectueaza.
     */
    public static void startRound(final InputLoader inputLoader,
                                  final Integer pos) {
        double sum = 0.0;
        double budgetUnit;

        ArrayList<ChildrenInit> childrenInit = inputLoader.getInitialData().getChildren();

        for (ChildrenInit child : childrenInit) {
                if (pos == 0) {
                    ArrayList<Double> score = child.getNiceScoreHistory();
                    score.add(child.getNiceScore());
                }
                AverageScoreStrategy averageScoreStrategy =
                        AverageScoreFactory.getInstance().createAverageScore(child.getAge());

                if (averageScoreStrategy != null) {
                    double findAverage = averageScoreStrategy.getAverageScore(child);
                    if (findAverage > Constants.LIMIT_AVERAGE_SCORE) {
                        findAverage = Constants.LIMIT_AVERAGE_SCORE;
                    }

                    child.setAverage(findAverage);
                    sum += findAverage;
                }
        }
        budgetUnit = inputLoader.getSantaBudget() / sum;

        if (pos == 0) {
            GiftCategory.getCategoryType(inputLoader, budgetUnit, childrenInit);
        } else {
            AssignGiftsSortStrategy assignGiftsSortStrategy =
                    AssignGiftsSortFactory.getInstance().createAssignGifts(
                            inputLoader.getAnnualChanges().get(pos - 1).getStrategy());

            ArrayList<ChildrenInit> children = assignGiftsSortStrategy.sortChildren(childrenInit);
            GiftCategory.getCategoryType(inputLoader, budgetUnit, children);
            FirstRound.setGifts(children, children);
            YellowGiftsAssign.getInstance().assignGifts(inputLoader, childrenInit);
        }
    }

    /**
     * Metoda ce seteaza cadoul corespunzator fiecarui copil din lista de copii initiala.
     * Acest lucru se efectueaza intrucat distribuirea efectiva de cadouri se realizeaza
     * pe o lista alternativa sortata in functie de strategia rundei curente.
     * @param childrenInit - lista de copii initiala
     * @param children - lista de copii sortata dupa care s-au impartit cadourile.
     */
    public static void setGifts(final ArrayList<ChildrenInit> childrenInit,
                                final ArrayList<ChildrenInit> children) {
        for (ChildrenInit child : children) {
            for (ChildrenInit childInit : childrenInit) {
                if (child.getId() == childInit.getId()) {
                    childInit.setReceivedGifts(child.getReceivedGifts());
                }
            }
        }
    }
}
