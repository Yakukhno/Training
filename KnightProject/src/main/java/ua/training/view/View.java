package ua.training.view;

public class View {

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

    public static final String ERROR_INPUT_MESSAGE = "Wrong data input!" +
            " Try again!";

    public void showMessage(String string) {
        System.out.println(string);
    }

}
