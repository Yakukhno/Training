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
     * Scanner to handle user input
     */
    private Scanner scanner;

    /**
     * Constructor with knightBuilder, view params.
     * @param knightBuilder builder for knight object
     * @param view view
     * @param scanner source of user input
     */
    public KnightController(AbstractKnightBuilder knightBuilder, View view,
                            Scanner scanner) {
        this.knightBuilder = knightBuilder;
        this.view = view;
        this.scanner = scanner;
    }

    /**
     * Initial method. Initializes scanner from console, sends messages
     * in view, invokes methods, which chooses parameters to build knight,
     * and builds final version of knight.
     */
    public void execute() {
        view.showMessage(View.WELCOME_MESSAGE);

        handleChainArmorInput();
        handleHelmetInput();
        handleShieldInput();
        handleWeaponInput();

        knight = knightBuilder.build();

        view.showMessage(View.COST_MESSAGE, knight.getAmmunitionCost());

        if (knight.getAmmunitionCost() != 0) {
            view.showMessage(View.SORTED_MESSAGE,
                    knight.sort(knight.weightAscComparator()));
            handlePriceRangeInput();
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
     * Shows message about chain armor and handle user input
     */
    private void handleChainArmorInput() {
        view.showMessage(View.CHAIN_ARMOR_MESSAGE);
        chooseChainArmor(readUserInput(
                scanner, ChainArmor.ChainArmorMaterial.values().length));
    }

    /**
     * Shows message about helmet and handle user input
     */
    private void handleHelmetInput() {
        view.showMessage(View.HELMET_MESSAGE);
        chooseHelmet(readUserInput(scanner, 2));
    }

    /**
     * Shows message about shield and handle user input
     */
    private void handleShieldInput() {
        view.showMessage(View.SHIELD_MATERIAL_MESSAGE);
        int shieldMaterialCode = readUserInput(scanner,
                Shield.ShieldMaterial.values().length);
        if (shieldMaterialCode != 0) {
            view.showMessage(View.SHIELD_SHAPE_MESSAGE);
            chooseShield(shieldMaterialCode, readUserInput(scanner,
                    Shield.Shape.values().length));
        }
    }

    /**
     * Shows message about weapon and handle user input
     */
    private void handleWeaponInput() {
        view.showMessage(View.WEAPON_MESSAGE);
        chooseWeapon(readUserInput(scanner, Weapon.WeaponType.values().length));
    }

    /**
     * Shows message about searching in price range and handle user input
     */
    private void handlePriceRangeInput() {
        view.showMessage(View.RANGE_MESSAGE);
        view.showMessage(View.MIN_BARRIER_MESSAGE);
        int minBarrier = readUserInput(scanner, Integer.MAX_VALUE);
        view.showMessage(View.MAX_BARRIER_MESSAGE);
        int maxBarrier = readUserInput(scanner, Integer.MAX_VALUE);

        view.showMessage(View.RANGE_RESULT_MESSAGE,
                knight.findAmmunition(knight
                        .ammunitionInPriceRangePredicate(
                                minBarrier, maxBarrier)));
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
        for (ChainArmor.ChainArmorMaterial material
                : ChainArmor.ChainArmorMaterial.values()) {
            if (material.getIndex() == code) {
                knightBuilder.buildChainArmor(material);
                return;
            }
        }
        if (code != 0) {
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
        for (HelmetProtection protection
                : HelmetProtection.values()) {
            if (protection.getIndex() == code) {
                knightBuilder.buildHelmet(protection.isProtected());
                return;
            }
        }
        if (code != 0) {
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
        for (Shield.ShieldMaterial item : Shield.ShieldMaterial.values()) {
            if (item.getIndex() == codeOfMaterial) {
                material = item;
            }
        }
        for (Shield.Shape item : Shield.Shape.values()) {
            if (item.getIndex() == codeOfShape) {
                knightBuilder.buildShield(material, item);
                return;
            }
        }
        if (codeOfMaterial != 0) {
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
        for (Weapon.WeaponType weaponType
                : Weapon.WeaponType.values()) {
            if (weaponType.getIndex() == code) {
                knightBuilder.buildWeapon(weaponType);
                return;
            }
        }
        if (code != 0) {
            throw new IllegalArgumentException("Illegal code");
        }
    }

    private enum HelmetProtection {
        PROTECTED(1, false), UNPROTECTED(2, true);

        private int index;
        private boolean value;

        HelmetProtection(int index, boolean value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public boolean isProtected() {
            return value;
        }
    }

}
