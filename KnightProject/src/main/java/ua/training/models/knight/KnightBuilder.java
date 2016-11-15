package ua.training.models.knight;

import ua.training.models.ammunition.ChainArmor;
import ua.training.models.ammunition.ChainArmor.ChainArmorMaterial;
import ua.training.models.ammunition.Helmet;
import ua.training.models.ammunition.Shield;
import ua.training.models.ammunition.Weapon;

import static ua.training.models.ammunition.ChainArmor.ChainArmorMaterial.*;
import static ua.training.models.ammunition.Weapon.WeaponType.*;

public class KnightBuilder {

    private Knight knight;

    public KnightBuilder() {
        knight = new Knight();
    }

    public KnightBuilder buildChainArmor(ChainArmorMaterial material) {
        switch (material) {
            case ALUMINUM :
                knight.setChainArmor(new ChainArmor(120, 4,
                        ALUMINUM));
                break;
            case COPPER :
                knight.setChainArmor(new ChainArmor(150, 7,
                        COPPER));
                break;
            case STEAL :
                knight.setChainArmor(new ChainArmor(200, 10,
                        STEAL));
                break;
            case LEATHER :
                knight.setChainArmor(new ChainArmor(70, 2,
                        LEATHER));
                break;
            default:
                throw new IllegalArgumentException("Illegal enum component");
        }
        return this;
    }

    public KnightBuilder buildShield(Shield.ShieldMaterial material, Shield.Shape shape) {
        Shield shield;

        if (material.equals(Shield.ShieldMaterial.COPPER)) {
            shield = new Shield(25, 2, Shield.ShieldMaterial.COPPER, null);
        } else if (material.equals(Shield.ShieldMaterial.STEAL)) {
            shield = new Shield(40, 3, Shield.ShieldMaterial.STEAL, null);
        } else if (material.equals(Shield.ShieldMaterial.WOOD)) {
            shield = new Shield(15, 1, Shield.ShieldMaterial.WOOD, null);
        } else {
            throw new IllegalArgumentException("Illegal enum component");
        }

        if (shape.equals(Shield.Shape.ROUND)) {
            shield.setPrice(shield.getPrice() + 4);
        } else if (shape.equals(Shield.Shape.OVAL)) {
            shield.setPrice(shield.getPrice() + 9);
        } else if (shape.equals(Shield.Shape.SQUARE)) {
            shield.setPrice(shield.getPrice() + 7);
        } else {
            throw new IllegalArgumentException("Illegal enum component");
        }
        shield.setShape(shape);

        return this;
    }

    public KnightBuilder buildWeapon(Weapon.WeaponType type) {
        switch (type) {
            case SWORD :
                knight.setWeapon(new Weapon(240, 3, SWORD));
                break;
            case SPEAR:
                knight.setWeapon(new Weapon(90, 3, SPEAR));
                break;
            case CROSSBOW:
                knight.setWeapon(new Weapon(80, 3, CROSSBOW));
                break;
            case MACE:
                knight.setWeapon(new Weapon(120, 3, MACE));
                break;
            default:
                throw new IllegalArgumentException("Illegal enum component");
        }

        return this;
    }

    public KnightBuilder buildHelmet(boolean isProtectedFace) {
        if (isProtectedFace) {
            knight.setHelmet(new Helmet(30, 2, true));
        } else {
            knight.setHelmet(new Helmet(10, 1, false));
        }
        return this;
    }

    public Knight build() {

        return knight;
    }

}
