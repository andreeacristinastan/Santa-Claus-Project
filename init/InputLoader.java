package init;

import java.util.ArrayList;

public final class InputLoader {
    private double numberOfYears;
    private double santaBudget;
    private DataInit dataInit;
    private ArrayList<AnnualChangesInit> annualChanges;

    public double getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(final double numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public DataInit getInitialData() {
        return dataInit;
    }

    public void setInitialData(final DataInit data) {
        this.dataInit = data;
    }

    public ArrayList<AnnualChangesInit> getAnnualChanges() {
        return annualChanges;
    }

    public void setAnnualChanges(final ArrayList<AnnualChangesInit> annualChanges) {
        this.annualChanges = annualChanges;
    }
}
