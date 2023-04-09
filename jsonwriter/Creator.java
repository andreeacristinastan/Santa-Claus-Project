package jsonwriter;

import common.Constants;
import init.ChildrenInit;
import init.InputLoader;

import java.util.ArrayList;

public final class Creator {
    private Creator() {
    }

    /**
     * Metoda realizeaza crearea copilului cu informatiile necesare pentru
     * fisierul de output.
     * Se realizeaza o noua instanta cu valorile pentru fiecare copil in parte
     * folosind design pattern-ul builder si se adauga in lista de output.
     * @param inputLoader - baza de date initiala
     * @param out - lista in care se va memora rezultatul final.
     */
    public static void createOutput(final InputLoader inputLoader,
                                 final ArrayList<Output> out) {
        ArrayList<ChildrenInit> children = inputLoader.getInitialData().getChildren();

            for (ChildrenInit child : children) {
                if (child.getAge() <= Constants.AGE_LIMIT) {
                    Output output = new Output.Builder(child.getId(), child.getLastName(),
                            child.getFirstName(), child.getCity(), child.getAge(),
                            child.getGiftsPreferences(), child.getAverage(),
                            child.getNiceScoreHistory(), child.getAssignedBudget(),
                            child.getReceivedGifts())
                    .build();

                    out.add(output);
                }
            }
    }
}
