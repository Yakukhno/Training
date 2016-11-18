package ua.training.view;

import java.util.Collection;

/**
 * Class prints string in console.
 *
 * @author Ivan Yakukhno
 */
public class View {

    //Text constants
    public static final String WELCOME_MESSAGE = "Hello, please, construct " +
            "your knight.";
    public static final String CHAIN_ARMOR_MESSAGE = "Choose chain armor for " +
            "your knight : 1 - aluminum, 2 - cooper, 3 - steal, 4 - leather " +
            "or 0 if don't want to wear chain armor on knight.";
    public static final String HELMET_MESSAGE = "Choose helmet for " +
            "your knight : 1 - protected, 2 - unprotected " +
            "or 0 if don't want to wear helmet armor on knight.";
    public static final String SHIELD_MATERIAL_MESSAGE = "Choose material for shield" +
            " for your knight : 1 - cooper, 2 - steal, 3 - wood " +
            "or 0 if don't want to give shield to knight.";
    public static final String SHIELD_SHAPE_MESSAGE = "Choose shape of shield" +
            " for your knight : 1 - round, 2 - oval, 3 - square.";
    public static final String WEAPON_MESSAGE = "Choose weapon for " +
            "your knight : 1 - sword, 2 - spear, 3 - crossbow, 4 - mace " +
            "or 0 if don't want to give weapon to knight.";
    public static final String RANGE_MESSAGE = "Please, input the price range for searching.";
    public static final String MIN_BARRIER_MESSAGE = "Min barrier:";
    public static final String MAX_BARRIER_MESSAGE = "Max barrier:";
    public static final String SORTED_MESSAGE = "Sorted by weight:";
    public static final String RANGE_RESULT_MESSAGE = "Found in specified range:";
    public static final String COST_MESSAGE = "Cost of ammunition:";
    public static final String ERROR_INPUT_MESSAGE = "Wrong data input!" +
            " Try again!";

    /**
     * Outputs message in console stream
     * @param string message to output
     */
    public void showMessage(String string) {
        System.out.println(string);
    }

    /**
     * Outputs collection with message in console stream
     * @param string message to output
     * @param collection collection to output
     */
    public void showMessage(String string, Collection<?> collection) {
        System.out.println(string + " " + collection + '\n');
    }

    /**
     * Outputs value with message in console stream
     * @param string message to output
     * @param value value to output
     */
    public void showMessage(String string, int value) {
        System.out.println(string + " " + value + '\n');
    }

}
