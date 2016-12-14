package ua.training.patterns.person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.addState(State.MUSHROOMER);
        person.addState(State.HUNTER);
        person.showState();
        System.out.println("=========");
        person.removeState(State.MUSHROOMER);
        person.showState();
    }
}

class Person {
    private List<State> states = new ArrayList<>(State.values().length);

    public void addState(State state) {
        states.add(state);
    }

    public void removeState(State state) {
        states.remove(state);
    }

    public void showState() {
        states.forEach((state1 -> System.out.println(state1.getString())));
    }
}

enum State {
    HUNTER("Seeing the animal"), FISHER("Is on the beach"), MUSHROOMER("Is on the mushroom field");

    private String string;

    State(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
