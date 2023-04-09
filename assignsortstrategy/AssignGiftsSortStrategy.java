package assignsortstrategy;

import init.ChildrenInit;

import java.util.ArrayList;

public interface AssignGiftsSortStrategy {

    /**
     * Interfata care face legatura intre metodele de sortare a
     * listei de copii si factory unde se stabileste ce tip de
     * strategie va fi efectuata runda curenta.
     * In functie de tipul de strategie, se sorteaza fie dupa average
     * score-ul orasului ce se afla ca o medie aritmetica a tuturor
     * scorurilor average ale fiecarui copil din acel oras in parte, fie
     * strict dupa average scorul fiecarui copil in parte.
     * Daca strategia anului curent era "id", lista de copii nu necesita nicio
     * sortare, intrucat ordinea in care copiii sunt memorati este exact ordinea
     * ceruta de "idSort".
     * @param childrenInit - lista de copii ce trebuie sortata.
     * @return - lista sortata de copii.
     */
    ArrayList<ChildrenInit> sortChildren(ArrayList<ChildrenInit> childrenInit);
}
