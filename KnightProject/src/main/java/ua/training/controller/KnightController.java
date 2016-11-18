package ua.training.controller;

import ua.training.model.ammunition.ChainArmor;
import ua.training.model.ammunition.Shield;
import ua.training.model.ammunition.Weapon;
import ua.training.model.knight.AbstractKnightBuilder;
import ua.training.model.knight.Knight;
import ua.training.view.View;

import java.util.Scanner;

/**
 * Controller for {@link Knight} class
 *
 * @author Ivan Yakukhno
 */
public class KnightController {

    /**
     * Model of knight
     */
    private Knight knight;

    /**
     * View
     */
    private View view;

    /**
     * Builder for knight object
     */
    private AbstractKnightBuilder knightBuilder;

    /**
     * Constructor with knightBuilder, view params.
     * @param knightBuilder builder for knight object
     * @param view view
     */
    public KnightController(AbstractKnightBuilder knightBuilder, View view) {
        this.knightBuilder = knightBuilder;
        this.view = view;
    }

    /**
     * Initial method. Initializes scanner from console, sends messages
     * in view, invokes methods, which chooses parameters to build knight,
     * and builds final version of knight.
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        view.showMessage(View.WELCOME_MESSAGE);
        view.showMessage(View.CHAIN_ARMOR_MESSAGE);
        chooseChainArmor(readUserInput(
                scanner, ChainArmor.ChainArmorMaterial.values().length));

        view.showMessage(View.HELMET_MESSAGE);
        chooseHelmet(readUserInput(scanner, 2));

        view.showMessage(View.SHIELD_MATERIAL_MESSAGE);
        int shieldMaterialCode = readUserInput(scanner,
                Shield.ShieldMaterial.values().length);
        if (shieldMaterialCode != 0) {
            view.showMessage(View.SHIELD_SHAPE_MESSAGE);
            chooseShield(shieldMaterialCode, readUserInput(scanner,
                    Shield.Shape.values().length));
        }

        view.showMessage(View.WEAPON_MESSAGE);
        chooseWeapon(readUserInput(scanner, Weapon.WeaponType.values().length));

        knight = knightBuilder.build();

        view.showMessage(View.COST_MESSAGE, knight.getAmmunitionCost());

        if (knight.getAmmunitionCost() != 0) {
            view.showMessage(View.SORTED_MESSAGE,
                    knight.sortAmmunitionByWeight());

            view.showMessage(View.RANGE_MESSAGE);
            view.showMessage(View.MIN_BARRIER_MESSAGE);
            int minBarrier = readUserInput(scanner, Integer.MAX_VALUE);
            view.showMessage(View.MAX_BARRIER_MESSAGE);
            int maxBarrier = readUserInput(scanner, Integer.MAX_VALUE);

            view.showMessage(View.RANGE_RESULT_MESSAGE,
                    knight.findInPriceRange(minBarrier, maxBarrier));
        }
    }

    /**
     * Reads user input and checks, if user number less than limit value.
     * If user integer input wrong, method call itself, until user inputs
     * correct data.
     * @param scanner scanner of user input
     * @param numberOfOptions limit value
     * @return user input integer
     */
    private int readUserInput(Scanner scanner, int numberOfOptions) {
        int userInput;
        try {
            userInput = Integer.parseInt(scanner.next());
            if (userInput > numberOfOptions || userInput < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            view.showMessage(View.ERROR_INPUT_MESSAGE);
            userInput = readUserInput(scanner, numberOfOptions);
        }
        return userInput;
    }

    /**
     * Chooses correct parameter for builder method, which builds chain armor,
     * in accordance with user input code.
     * @param code user input code
     *
     * @throws IllegalArgumentException if user code doesn't process in
     * switch construction
     */
    private void chooseChainArmor(int code) {
        switch (code) {
            case 1 :
                knightBuilder.buildChainArmor(
                        ChainArmor.ChainArmorMaterial.ALUMINUM);
                break;
            case 2 :
                knightBuilder.buildChainArmor(
                        ChainArmor.ChainArmorMaterial.COPPER);
                break;
            case 3 :
                knightBuilder.buildChainArmor(
                        ChainArmor.ChainArmorMaterial.STEAL);
                break;
            case 4 :
                knightBuilder.buildChainArmor(
                        ChainArmor.ChainArmorMaterial.LEATHER);
                break;
            case 0 :
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

    /**
     * Chooses correct parameter for builder method, which builds helmet,
     * in accordance with user input code.
     * @param code user input code
     *
     * @throws IllegalArgumentException if user code doesn't process in
     * switch construction
     */
    private void chooseHelmet(int code) {
        switch (code) {
            case 1 :
                knightBuilder.buildHelmet(true);
                break;
            case 2 :
                knightBuilder.buildHelmet(false);
                break;
            case 0 :
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

    /**
     * Chooses correct parameter for builder method, which builds shield,
     * in accordance with user input code.
     * @param codeOfMaterial user input code of material
     * @param codeOfShape user input code of shape
     *
     * @throws IllegalArgumentException if user code doesn't process in
     * switch construction
     */
    private void chooseShield(int codeOfMaterial, int codeOfShape) {
        Shield.ShieldMaterial material = null;
        switch (codeOfMaterial) {
            case 1 :
                material = Shield.ShieldMaterial.COPPER;
                break;
            case 2 :
                material = Shield.ShieldMaterial.STEAL;
                break;
            case 3 :
                material = Shield.ShieldMaterial.WOOD;
                break;
            case 0 :
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }

        switch (codeOfShape) {
            case 1 :
                knightBuilder.buildShield(material, Shield.Shape.ROUND);
                break;
            case 2 :
                knightBuilder.buildShield(material, Shield.Shape.OVAL);
                break;
            case 3 :
                knightBuilder.buildShield(material, Shield.Shape.SQUARE);
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

    /**
     * Chooses correct parameter for builder method, which builds weapon,
     * in accordance with user input code.
     * @param code user input code
     *
     * @throws IllegalArgumentException if user code doesn't process in
     * switch construction
     */
    private void chooseWeapon(int code) {
        switch (code) {
            case 1 :
                knightBuilder.buildWeapon(Weapon.WeaponType.SWORD);
                break;
            case 2 :
                knightBuilder.buildWeapon(Weapon.WeaponType.SPEAR);
                break;
            case 3 :
                knightBuilder.buildWeapon(Weapon.WeaponType.CROSSBOW);
                break;
            case 4 :
                knightBuilder.buildWeapon(Weapon.WeaponType.MACE);
                break;
            case 0 :
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

}
