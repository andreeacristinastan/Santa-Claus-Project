package elfstrategy;

import common.Constants;
import init.ChildrenInit;

public final class PinkElf implements ElfStrategy {
    @Override
    public void setBudget(final ChildrenInit child,
                          final double budgetUnit) {
        double budget = budgetUnit * child.getAverage();
        double pink = budget + budget * Constants.MULTIPLY / Constants.DIVISION;
        child.setAssignedBudget(pink);
    }
}
