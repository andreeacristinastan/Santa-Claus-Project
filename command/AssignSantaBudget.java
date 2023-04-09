package command;

import init.InputLoader;

public final class AssignSantaBudget implements Command {
    private final Double newSantaBudget;
    private final InputLoader inputLoader;
    private Double oldSantaBudget;

    @Override
    public void execute() {
        oldSantaBudget = inputLoader.getSantaBudget();
        inputLoader.setSantaBudget(newSantaBudget);
    }

    @Override
    public void undo() {
        inputLoader.setSantaBudget(oldSantaBudget);
    }

    public AssignSantaBudget(final InputLoader inputLoader, final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
        this.inputLoader = inputLoader;
    }

}
