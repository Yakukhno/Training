package ua.training.models.knight;

import ua.training.database.Price;
import ua.training.models.ammunition.ChainArmor;
import ua.training.models.ammunition.ChainArmor.ChainArmorMaterial;
import ua.training.models.ammunition.Helmet;
import ua.training.models.ammunition.Shield;
import ua.training.models.ammunition.Weapon;

import static ua.training.models.ammunition.ChainArmor.ChainArmorMaterial.*;
import static ua.training.models.ammunition.Weapon.WeaponType.*;

public class KnightBuilder {

    private IKnight knight;

    public KnightBuilder() {
        knight = new Knight();
    }

    public KnightBuilder buildChainArmor(ChainArmorMaterial material) {
        switch (material) {
            case ALUMINUM :
                knight.setChainArmor(new ChainArmor(
                        Price.ALUMINUM_CHAIN_ARMOR.getPrice(),
                        Price.ALUMINUM_CHAIN_ARMOR.getWeight(),
                        ALUMINUM));
                break;
            case COPPER :
                knight.setChainArmor(new ChainArmor(
                        Price.COPPER_CHAIN_ARMOR.getPrice(),
                        Price.COPPER_CHAIN_ARMOR.getWeight(),
                        COPPER));
                break;
            case STEAL :
                knight.setChainArmor(new ChainArmor(
                        Price.STEAL_CHAIN_ARMOR.getPrice(),
                        Price.STEAL_CHAIN_ARMOR.getWeight(),
                        STEAL));
                break;
            case LEATHER :
                knight.setChainArmor(new ChainArmor(
                        Price.LEATHER_CHAIN_ARMOR.getPrice(),
                        Price.LEATHER_CHAIN_ARMOR.getWeight(),
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
            shield = new Shield(
                    Price.COPPER_SHIELD.getPrice(),
                    Price.COPPER_SHIELD.getWeight(),
                    Shield.ShieldMaterial.COPPER,
                    null);
        } else if (material.equals(Shield.ShieldMaterial.STEAL)) {
            shield = new Shield(
                    Price.STEAL_SHIELD.getPrice(),
                    Price.STEAL_SHIELD.getWeight(),
                    Shield.ShieldMaterial.STEAL,
                    null);
        } else if (material.equals(Shield.ShieldMaterial.WOOD)) {
            shield = new Shield(
                    Price.WOOD_SHIELD.getPrice(),
                    Price.WOOD_SHIELD.getWeight(),
                    Shield.ShieldMaterial.WOOD,
                    null);
        } else {
            throw new IllegalArgumentException("Illegal enum component");
        }

        if (shape.equals(Shield.Shape.ROUND)) {
            shield.setPrice(shield.getPrice() + Price.ROUND_SHIELD.getPrice());
        } else if (shape.equals(Shield.Shape.OVAL)) {
            shield.setPrice(shield.getPrice() + Price.OVAL_SHIELD.getPrice());
        } else if (shape.equals(Shield.Shape.SQUARE)) {
            shield.setPrice(shield.getPrice() + Price.SQUARE_SHIELD.getPrice());
        } else {
            throw new IllegalArgumentException("Illegal enum component");
        }
        shield.setShape(shape);
        knight.setShield(shield);

        return this;
    }

    public KnightBuilder buildWeapon(Weapon.WeaponType type) {
        switch (type) {
            case SWORD :
                knight.setWeapon(new Weapon(
                        Price.SWORD.getPrice(),
                        Price.SWORD.getWeight(),
                        SWORD));
                break;
            case SPEAR:
                knight.setWeapon(new Weapon(
                        Price.SPEAR.getPrice(),
                        Price.SPEAR.getWeight(),
                        SPEAR));
                break;
            case CROSSBOW:
                knight.setWeapon(new Weapon(
                        Price.CROSSBOW.getPrice(),
                        Price.CROSSBOW.getWeight(),
                        CROSSBOW));
                break;
            case MACE:
                knight.setWeapon(new Weapon(
                        Price.MACE.getPrice(),
                        Price.MACE.getWeight(),
                        MACE));
                break;
            default:
                throw new IllegalArgumentException("Illegal enum component");
        }

        return this;
    }

    public KnightBuilder buildHelmet(boolean isProtectedFace) {
        if (isProtectedFace) {
            knight.setHelmet(new Helmet(
                    Price.PROTECTED_HELMET.getPrice(),
                    Price.PROTECTED_HELMET.getWeight(),
                    true));
        } else {
            knight.setHelmet(new Helmet(
                    Price.UNPROTECTED_HELMET.getPrice(),
                    Price.UNPROTECTED_HELMET.getWeight(),
                    false));
        }
        return this;
    }

    public IKnight build() {

        return knight;
    }

}
