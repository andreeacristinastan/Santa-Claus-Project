package annualchanges;

import init.ChildrenInit;
import init.ChildrenUpdatesInit;
import init.InputLoader;

import java.util.ArrayList;

public final class ChildrenChanges {
    private ChildrenChanges() {
    }

    /**
     * Metoda se ocupa cu efectuarea actualizarilor in ceea ce priveste copiii.
     * Initial se parcurge lista de update-uri si ista de copii pana cand se ajunge
     * la copilul cautat.
     * Se adauga niceScore-ul in lista de history, apoi se apeleaza metoda care va
     * actualiza lista de preferinte a copilului.
     * @param inputLoader - baza de date initiala
     * @param childrenUpdatesInit - lista cu actualizari pentru copii pentru runda
     *                            curenta
     */
    public static void makeChangeChildren(final InputLoader inputLoader,
                                          final ArrayList<ChildrenUpdatesInit>
                                                  childrenUpdatesInit) {
        ArrayList<ChildrenInit> children = inputLoader.getInitialData().getChildren();

        for (ChildrenUpdatesInit childrenUpdates : childrenUpdatesInit) {
            for (ChildrenInit child : children) {
                if (childrenUpdates.getId() == child.getId()) {
                    if (childrenUpdates.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(childrenUpdates.getNiceScore());
                    }

                    if (childrenUpdates.getGiftsPreferences().size() != 0) {
                        checkPreferences(child, childrenUpdates.getGiftsPreferences());
                    }

                    if (childrenUpdates.getElf() != null) {
                        child.setElf(childrenUpdates.getElf());
                    }
                }
            }
        }
    }

    /**
     * Metoda se ocupa cu actualizarea listei de preferinte.
     * Initial, am ales sa tratez cazul in care lista cu actualizari contine
     * un String de mai multe ori, realizand un nou arrayList in care sa memorez lista
     * de actualizari.
     * Dupa ce am obtinut o lista valida de actualizari, am procedat asemanator si cu lista
     * deja existenta de preferinte a copilului (daca unul dintre elemente era deja in copia
     * listei initiale, il eliminam pentru a-l adauga pe o pozitie prioritara).
     * In final, am ales sa adaug elementele parcurgand lista cu noile preferinte in sens invers.
     * @param children - copilul pentru care se va efectua actualizarea listei de preferinte
     * @param giftPreferences - lista cu noile preferinte de adaugat in lista initiala.
     */
    public static void checkPreferences(final ChildrenInit children,
                                        ArrayList<String> giftPreferences) {

        ArrayList<String> copyWishList = new ArrayList<>(children.getGiftsPreferences());
        ArrayList<String> copyNewWishlist = new ArrayList<>();

        for (String giftPreference : giftPreferences) {
            if (!copyNewWishlist.contains(giftPreference)) {
                copyNewWishlist.add(giftPreference);
            }
        }

        giftPreferences.clear();
        giftPreferences = copyNewWishlist;

        for (String giftPreference : giftPreferences) {
            if (children.getGiftsPreferences().contains(giftPreference)) {
                copyWishList.remove(giftPreference);
            }
        }

        children.getGiftsPreferences().clear();
        children.setGiftsPreferences(copyWishList);

        for (int i = giftPreferences.size() - 1; i >= 0; i--) {
            children.getGiftsPreferences().add(0, giftPreferences.get(i));
        }
    }

}
