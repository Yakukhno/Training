package ua.training.model.knight;

import ua.training.database.Price;
import ua.training.model.knight.ammunition.ChainArmor;
import ua.training.model.knight.ammunition.ChainArmor.ChainArmorMaterial;
import ua.training.model.knight.ammunition.Helmet;
import ua.training.model.knight.ammunition.Shield;
import ua.training.model.knight.ammunition.Weapon;

import static ua.training.model.knight.ammunition.ChainArmor.ChainArmorMaterial.*;
import static ua.training.model.knight.ammunition.Weapon.WeaponType.*;

/**
 * Implementation of <tt>AbstractKnightBuilder</tt> abstract class.
 * Class build {@link Knight} object using data from {@link Price} enum.
 *
 * @author Ivan Yakukhno
 * @see Knight
 * @see AbstractKnightBuilder
 * @see IAmmunitionCarrier
 */
public class KnightBuilder extends AbstractKnightBuilder {

    /**
     * Sets chain armor attribute in knight property
     * using data from {@link Price} enum.
     * @param material element of {@link ChainArmor.ChainArmorMaterial} enum
     * @return same instance of this class with changed knight object
     *
     * @throws IllegalArgumentException if defined
     * in {@link ChainArmor.ChainArmorMaterial} enum element doesn't process
     * in switch construction
     */
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

    /**
     * {@inheritDoc}
     *
     * Uses data from {@link Price} enum.
     *
     * @throws IllegalArgumentException if defined
     * in {@link Shield.ShieldMaterial} or {@link Shield.Shape} enum element
     * doesn't process in switch construction
     */
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

    /**
     * {@inheritDoc}
     *
     * Uses data from {@link Price} enum.
     *
     * @throws IllegalArgumentException if defined in {@link Weapon.WeaponType}
     * enum element doesn't process in switch construction
     */
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

    /**
     * {@inheritDoc}
     *
     * Uses data from {@link Price} enum.
     */
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

}
