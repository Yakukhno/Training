package ua.training.patterns.pizza;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .addDough(Dough.NEAPOLITAN)
                .addSauce(Sauce.GREMOLATA)
                .addTopping(Topping.MUSHROOMS)
                .addTopping(Topping.CHICKEN)
                .addTopping(Topping.CORN)
                .build();
        System.out.println(pizza.getPrice());
    }
}

class Pizza {
    private Dough dough = Dough.NEW_YORK;
    private Sauce sauce = Sauce.TOMATO;
    private List<Topping> topping = new ArrayList<>();

    private int price;

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<Topping> getTopping() {
        return topping;
    }

    public void setTopping(List<Topping> topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

enum Dough {
    NEAPOLITAN(80), NEW_YORK(65), SICILIAN(85);

    private int price;

    Dough(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Sauce {
    TOMATO(7), PESTO(10), TAPENADE(8), MUHAMMARA(9), GREMOLATA(11), BARBECUE(9);

    private int price;

    Sauce(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

enum Topping {
    TOMATOES(15), MUSHROOMS(25), CHICKEN(23), BEACON(30), CORN(10), SAUSAGE(20);

    private int price;

    Topping(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class PizzaBuilder {
    private Pizza pizza = new Pizza();

    public PizzaBuilder addDough(Dough dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder addSauce(Sauce sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    public PizzaBuilder addTopping(Topping topping) {
        pizza.getTopping().add(topping);
        return this;
    }

    public PizzaBuilder removeTopping(Topping topping) {
        pizza.getTopping().remove(topping);
        return this;
    }

    public Pizza build() {
        pizza.setPrice(
                (int) (pizza.getDough().getPrice()
                        + pizza.getSauce().getPrice()
                        + pizza.getTopping().stream()
                        .mapToInt(Topping::getPrice)
                        .reduce((left, right) -> left + right)
                        .orElse(0) * 1.2));
        return pizza;
    }

}
