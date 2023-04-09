package receivegifts;

import common.Constants;
import elfstrategy.ElfFactory;
import elfstrategy.ElfStrategy;
import init.ChildrenInit;
import init.InputLoader;
import java.util.ArrayList;

public final class GiftCategory {
    private GiftCategory() {
    }

    /**
     * Metoda asigneaza pentru fiecare copil bugetul pe care il are
     * mosul pentru el, apoi, tot pentru fiecare copil in parte, este
     * parcursa lista de preferinte si apelata metoda care stabileste
     * daca (,) cadoul din acea categorie trebuie asignat sau nu.
     * @param inputLoader - baza de date initiala.
     * @param budgetUnit - unitatea de buget la care se va limita calcularea
     *                   bugetului alocat pentru fiecare copil in parte.
     * @param children - lista de copii ce vor primi cadouri.
     */
    public static void getCategoryType(final InputLoader inputLoader,
                                       final Double budgetUnit,
                                       final ArrayList<ChildrenInit> children) {

        for (ChildrenInit child : children) {
            child.getReceivedGifts().clear();
            if (child.getAge() <= Constants.AGE_LIMIT) {
                ElfStrategy elfStrategy =
                        ElfFactory.getInstance().createElfBudget(child.getElf());
                elfStrategy.setBudget(child, budgetUnit);

                ArrayList<String> preferences = child.getGiftsPreferences();

                for (String preference: preferences) {
                    GiftAssign.getPresent(inputLoader, child, preference);
                }
            }
        }

    }
}
