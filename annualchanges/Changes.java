package annualchanges;

import command.Invoker;
import command.AssignSantaBudget;
import command.IncreaseAge;
import enums.CommandType;
import init.AnnualChangesInit;
import init.ChildrenInit;
import init.InputLoader;

import java.util.ArrayList;

public final class Changes {

    private final Invoker invoker;

    public Changes() {
        invoker = new Invoker();
    }
    /**
     * Fiind data o lista cu modificarile ce trebuie efectuate pentru anul curent, metoda
     * actualizeaza initial bugetul mosului si creste varsta copiilor cu inca un an folosindu-se
     * de design pattern-ul command apeland invoker-ul, apoi verifica pe rand ce tip de
     * modificare este prezenta in anul curent.
     * In functie de ce trebuie modificat, se apeleaza noi metode care sa efectueze
     * modificarile sau se actualizeaza datele necesare.
     * @param inputLoader - baza de date initiala
     * @param pos - pozitia din arrayList-ul de schimbari anuale ce reprezinta practic
     *            ce modificari trebuie efectuate in functie de runda.
     */
    public void makeChanges(final InputLoader inputLoader, final Integer pos) {
        ArrayList<AnnualChangesInit> changes = inputLoader.getAnnualChanges();
        ArrayList<ChildrenInit> children = inputLoader.getInitialData().getChildren();

        for (CommandType commandType : CommandType.values()) {
            if (commandType.type.equals("increase age")) {
                invoker.edit(new IncreaseAge(inputLoader.getInitialData().getChildren()));
            } else if (commandType.type.equals("set new santa budget")) {
                invoker.edit(new AssignSantaBudget(inputLoader,
                        changes.get(pos - 1).getNewSantaBudget()));
            }
        }

        if (changes.get(pos - 1).getChildrenUpdates().size() != 0) {
            ChildrenChanges.makeChangeChildren(inputLoader,
                    changes.get(pos - 1).getChildrenUpdates());
        }

        if (changes.get(pos - 1).getNewChildren().size() != 0) {
            for (ChildrenInit child : changes.get(pos - 1).getNewChildren()) {
                child.getNiceScoreHistory().add(child.getNiceScore());
                children.add(child);
            }
        }

        if (changes.get(pos - 1).getNewGifts().size() != 0) {
            inputLoader.getInitialData().getSantaGiftsList().addAll(
                    changes.get(pos - 1).getNewGifts());
        }
    }
}
