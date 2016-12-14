package ua.training.patterns.salad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Store store = new Store(new HashMap<Ingredient, Integer>(){
            {
                put(Ingredient.CARROTS, 2);
                put(Ingredient.EGGS, 3);
                put(Ingredient.MUSHROOMS, 4);
                put(Ingredient.LETTUCE, 1);
                put(Ingredient.CHEESE, 2);
            }
        });

        Salad salad;
        try {
            salad = new SaladBuilder(store)
                    .addIngredient(Ingredient.LETTUCE)
                    .addIngredient(Ingredient.MUSHROOMS)
                    .addIngredient(Ingredient.EGGS)
                    .build();
            salad.showIngredients();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("================");

        try {
            salad = new SaladBuilder(store)
                    .addIngredient(Ingredient.LETTUCE)
                    .build();
            salad.showIngredients();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Salad {
    private List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void showIngredients() {
        System.out.println(ingredients);
    }
}

enum Ingredient {
    LETTUCE, TOMATOES, BEANS, MUSHROOMS, NUTS, EGGS, CHEESE, CARROTS, PEPPERS
}

class SaladBuilder {
    private Salad salad = new Salad();
    private Store store;

    public SaladBuilder(Store store) {
        this.store = store;
    }

    public SaladBuilder addIngredient(Ingredient ingredient) {
        salad.getIngredients().add(ingredient);
        return this;
    }

    public Salad build() throws Exception {
        for (Map.Entry<Ingredient, Integer> entry
                : store.getProducts().entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
            } else {
                throw new Exception("There no ingredients in store");
            }
        }
        return salad;
    }
}

class Store {
    private Map<Ingredient, Integer> products = new HashMap<>();

    public Store(Map<Ingredient, Integer> products) {
        this.products = products;
    }

    public Map<Ingredient, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Ingredient, Integer> products) {
        this.products = products;
    }
}