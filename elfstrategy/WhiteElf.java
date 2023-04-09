package elfstrategy;

import init.ChildrenInit;

public final class WhiteElf implements ElfStrategy {
    @Override
    public void setBudget(final ChildrenInit child,
                          final double budgetUnit) {
        child.setAssignedBudget(budgetUnit * child.getAverage());
    }
}
