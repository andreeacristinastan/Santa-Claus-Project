package receivegifts;

import init.ChildrenInit;
import init.InputLoader;
import init.SantaGiftsListInit;

import java.util.ArrayList;
import java.util.Comparator;

public final class GiftAssign {
    private GiftAssign() {
    }

    /**
     * Metoda atribuie cadourile potrivite copiilor.
     * Initial, salvez lista de cadouri disponibila a mosului, urmand sa
     * sortez lista de cadouri crescator dupa pret, apoi sa apelez metoda
     * care verifica daca copilul a primit un cadou si actualizeaza bugetul
     * alocat pentru acesta.
     * Parcurg intreaga lista de cadouri si verific daca, categoria din
     * care face acesta parte este intre lista de preferinte a copilului.
     * Daca este si pretul este suficient de mic pentru a fi asignat copilului,
     * este adaugat in variabila ce retine cadoul primit.
     * Dupa ce toate conditiile sunt indeplinite, cadoul este adaugat in lista finala
     * de cadouri a copilului.
     * @param inputLoader - baza de date initiala.
     * @param child - copilul caruia i se atribuie un cadou.
     * @param preference - categoria de preferinta din care face parte cadoul ce
     *                   urmeaza a fi atribuit.
     */
    public static void getPresent(final InputLoader inputLoader,
                                  final ChildrenInit child,
                                  final String preference) {

        ArrayList<SantaGiftsListInit> santaGiftsList =
                inputLoader.getInitialData().getSantaGiftsList();
        SantaGiftsListInit santaGift = null;

        santaGiftsList.sort(Comparator.comparingDouble(SantaGiftsListInit::getPrice));

        final double budgetChild = checkGift(child, child.getAssignedBudget());

        for (SantaGiftsListInit gift : santaGiftsList) {
            if (gift.getCategory().equals(preference) && gift.getQuantity() != 0) {
                if (budgetChild >= gift.getPrice()) {
                        santaGift = gift;
                        break;
                }
            }
        }
        if (santaGift != null) {
            Double quantity = santaGift.getQuantity();
            santaGift.setQuantity(quantity - 1);
            ReceivedGift receivedGift = new ReceivedGift(santaGift.getProductName(),
                    santaGift.getPrice(), santaGift.getCategory());
            child.getReceivedGifts().add(receivedGift);
        }
    }

    /**
     * Metoda verifica daca lista de cadouri primite a copilului contine vreun
     * element si actualizeaza bugetul alocat pentru acesta daca este cazul.
     * @param children - copilul pentru care se efectueaza verificarea.
     * @param budgetChild - bugetul asignat copilului.
     * @return - bugetul actualizat alocat pentru copil.
     */
    public static Double checkGift(final ChildrenInit children,
                                   Double budgetChild) {
        if (children.getReceivedGifts().size() != 0) {
            for (ReceivedGift giftsList : children.getReceivedGifts()) {
                budgetChild = budgetChild - giftsList.getPrice();
            }
        }
        return budgetChild;
    }
}
