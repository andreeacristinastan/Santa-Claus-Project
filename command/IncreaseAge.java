package command;

import init.ChildrenInit;

import java.util.ArrayList;

public final class IncreaseAge implements Command {
    private final ArrayList<ChildrenInit> children;

    @Override
    public void execute() {
        for (ChildrenInit child : children) {
            int oldAge = child.getAge();
            child.setAge(oldAge + 1);
        }

    }

    @Override
    public void undo() {
        for (ChildrenInit child : children) {
            int oldAge = child.getAge();
            child.setAge(oldAge - 1);
        }
    }

    public IncreaseAge(final ArrayList<ChildrenInit> children) {
        this.children = children;
    }
}
