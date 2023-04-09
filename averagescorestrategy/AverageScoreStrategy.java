package averagescorestrategy;

import init.ChildrenInit;

public interface AverageScoreStrategy {

    /**
     * Interfata care face legatura intre metodele de aflare a
     * averageScore-ului si factory unde se stabileste varsta
     * fiecarui copil.
     * In functie de varsta fiecaruia, se calculeaza fie ca medie
     * aritmetica, fie ca medie ponderata, singura exceptie fiind
     * in cazul copiilor mici (<5 ani) care au averageScore-ul by
     * default 10.
     * Dupa ce aceste calcule sunt efectuate, se verifica daca exista
     * un niceScoreBonus si daca se regaseste, acesta este adaugat conform
     * formulei prezente in cerinta la averageScore-ul final.
     * @param child - copilul pentru care se calculeaza averageScore-ul
     * @return - valoarea calculata a averageScore-ului.
     */
    double getAverageScore(ChildrenInit child);
}
