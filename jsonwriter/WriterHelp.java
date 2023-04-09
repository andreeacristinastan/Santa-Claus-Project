package jsonwriter;


import java.util.ArrayList;

public final class WriterHelp {
    private static WriterHelp instance = null;

    private WriterHelp() {
    }

    /**
     * Metoda ce ajuta la crearea singletonului.
     * @return - instanta clasei.
     */

    public static WriterHelp getInstance() {
        if (instance == null) {
            instance = new WriterHelp();
        }
        return instance;
    }

    /**
     * Metoda se ocupa cu crearea entitatilor pentru scrierea in fisierul de output.
     * @param numberOfRound - numarul rundei curente.
     * @param child - entitatea children ce va face parte din output.
     * @param finalArray - array-ul final in care se afla toate elementele pentru
     *                   scriere in json.
     * @param out - informatiile despre copii grupate intr-un arrayList.
     * @param annualChildren - entitatea finala in cadrul careia se regasesc toate
     *                       informatiile din json.
     */
    public void createWriteFile(final Integer numberOfRound, final Children child,
                                final ArrayList<Children> finalArray,
                                final ArrayList<Output> out, final AnnualChildren annualChildren) {
        if (numberOfRound != 0) {
            Children children = new Children();
            children.setChildren(out);
            finalArray.add(children);
        } else {
            child.setChildren(out);
            finalArray.add(child);
        }
        annualChildren.setAnnualChildren(finalArray);
    }
}
