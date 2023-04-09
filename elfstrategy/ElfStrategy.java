package elfstrategy;

import init.ChildrenInit;

public interface ElfStrategy {

    /**
     * Interfata ce creaza legatura intre factory-ul ce stabileste
     * tipul elfului si metodele de actualizare a bugetului in functie
     * de elfi.
     * In functie de culoarea elfului, bugetul pentru un copil fie se pastreaza
     * la fel, fie se calculeaza aduagand/scazand o anumita valoarea din acesta.
     * @param child - copilul pentru care se face actualizarea bugetului.
     * @param budgetUnit - valoarea care ajuta la calculul bugetului pentru
     *                   fiecare copil in parte.
     */
    void setBudget(ChildrenInit child, double budgetUnit);
}
