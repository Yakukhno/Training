package ua.training.model.knight;

import ua.training.model.knight.ammunition.ChainArmor;
import ua.training.model.knight.ammunition.Shield;
import ua.training.model.knight.ammunition.Weapon;

/**
 * This class provides a skeletal implementation of the {@link Knight}
 * interface to minimize the effort required to implement this interface.
 *
 * @author Ivan Yakukhno
 * @see Knight
 */
public abstract class AbstractKnightBuilder {

    /**
     * Knight to build.
     */
    protected Knight knight;

    /**
     * Constructor initialize knight reference
     * with object of {@link Knight} class.
     */
    protected AbstractKnightBuilder() {
        knight = new Knight();
    }

    /**
     * Sets chain armor attribute in knight property.
     * @param material element of {@link ChainArmor.ChainArmorMaterial} enum
     * @return same instance of this class with changed knight object
     */
    public abstract KnightBuilder buildChainArmor(ChainArmor.ChainArmorMaterial material);

    /**
     * Sets shield attribute in knight property.
     * @param material element of {@link Shield.ShieldMaterial} enum
     * @param shape element of {@link Shield.Shape} enum
     * @return same instance of this class with changed knight object
     */
    public abstract KnightBuilder buildShield(Shield.ShieldMaterial material, Shield.Shape shape);

    /**
     * Sets weapon attribute in knight property.
     * @param type element of {@link Weapon.WeaponType} enum
     * @return same instance of this class with changed knight object
     */
    public abstract KnightBuilder buildWeapon(Weapon.WeaponType type);

    /**
     * Sets helmet attribute in knight property.
     * @param isProtectedFace parameter to set property isProtectedFace
     * @return same instance of this class with changed knight object
     */
    public abstract KnightBuilder buildHelmet(boolean isProtectedFace);

    /**
     * Returns constructed {@link Knight} object.
     * @return constructed {@link Knight} object
     */
    public Knight build() {
        return knight;
    }

}
