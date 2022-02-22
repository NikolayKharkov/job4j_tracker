package ru.job4j.tracker;

public class MemmoryTestAction implements UserAction {
    private final Output out;

    public MemmoryTestAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Test Memory";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i != 100000; i++) {
            tracker.add(new Item("Test memory", "Desc1"));
        }
        return true;
    }
}
