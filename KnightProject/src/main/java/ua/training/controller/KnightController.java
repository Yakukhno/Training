package ua.training.controller;

import ua.training.model.knight.ammunition.ChainArmor;
import ua.training.model.knight.ammunition.Shield;
import ua.training.model.knight.ammunition.Weapon;
import ua.training.model.knight.AbstractKnightBuilder;
import ua.training.model.knight.Knight;
import ua.training.view.View;

import java.util.Scanner;

public class KnightController {

    private Knight knight;
    private View view;
    private AbstractKnightBuilder knightBuilder;

    public KnightController(AbstractKnightBuilder knightBuilder, View view) {
        this.knightBuilder = knightBuilder;
        this.view = view;
    }

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

    private void chooseChainArmor(int code) {
        switch (code) {
            case 1 :
                knightBuilder.buildChainArmor(ChainArmor.ChainArmorMaterial.ALUMINUM);
                break;
            case 2 :
                knightBuilder.buildChainArmor(ChainArmor.ChainArmorMaterial.COPPER);
                break;
            case 3 :
                knightBuilder.buildChainArmor(ChainArmor.ChainArmorMaterial.STEAL);
                break;
            case 4 :
                knightBuilder.buildChainArmor(ChainArmor.ChainArmorMaterial.LEATHER);
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

    private void chooseHelmet(int code) {
        switch (code) {
            case 1 :
                knightBuilder.buildHelmet(true);
                break;
            case 2 :
                knightBuilder.buildHelmet(false);
                break;
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

    private void chooseShield(int codeOfMaterial, int codeOfShape) {
        Shield.ShieldMaterial material;
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
            default:
                throw new IllegalArgumentException("Illegal code");
        }
    }

}
