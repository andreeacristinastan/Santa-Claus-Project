package yellowelfassign;

import common.Constants;
import init.ChildrenInit;
import init.InputLoader;
import init.SantaGiftsListInit;
import receivegifts.ReceivedGift;

import java.util.ArrayList;

public final class YellowGiftsAssign {
    private static YellowGiftsAssign instance = null;

    private YellowGiftsAssign() {

    }

    /**
     * Metoda ce ajuta la crearea singletonului.
     * @return - instanta clasei.
     */

    public static YellowGiftsAssign getInstance() {
        if (instance == null) {
            instance = new YellowGiftsAssign();
        }
        return instance;
    }

    /**
     * Metoda parcurge lista de copii si verifica ce copil are
     * atribuit elful galben si apeleaza metoda ce aloca cadou
     * pentru acesta in cazul in care nu a primit cadou
     * de la mosul.
     * @param inputLoader - baza de date initiala.
     * @param children - lista de copii.
     */
    public void assignGifts(final InputLoader inputLoader,
                            final ArrayList<ChildrenInit> children) {
        for (ChildrenInit child : children) {
            if (child.getElf().equals(Constants.YELLOW_ELF)
                    && child.getReceivedGifts().size() == 0) {
                    setYellowGift(inputLoader, child, child.getGiftsPreferences().get(0));
            }
        }
    }

    /**
     * Metoda aloca un cadou copilului ce are atribuit elful galben
     * doar daca cantitatea cadoului nu este 0 si face parte din prima
     * categorie de preferinte a copilului.
     * @param inputLoader - baza de date initiala.
     * @param child - copilul pentru care se doreste atribuirea cadoului.
     * @param preference - prima preferinta a copilului.
     */
    public void setYellowGift(final InputLoader inputLoader,
                              final ChildrenInit child,
                              String preference) {
        ArrayList<SantaGiftsListInit> gifts = inputLoader.getInitialData().getSantaGiftsList();

        for (SantaGiftsListInit gift : gifts) {
            if (gift.getCategory().equals(preference)) {
                if (gift.getQuantity() == 0) {
                    break;
                }
                ArrayList<ReceivedGift> receivedGifts = new ArrayList<>();
                ReceivedGift receivedGift = new ReceivedGift(gift.getProductName(),
                        gift.getPrice(), gift.getCategory());

                receivedGifts.add(receivedGift);
                gift.setQuantity(gift.getQuantity() - 1);
                child.setReceivedGifts(receivedGifts);
                break;
            }
        }
    }
}
