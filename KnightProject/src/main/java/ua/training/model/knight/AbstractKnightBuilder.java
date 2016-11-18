package ua.training.model.knight;

import ua.training.model.ammunition.ChainArmor;
import ua.training.model.ammunition.Shield;
import ua.training.model.ammunition.Weapon;

/**
 * This class provides methods to build object of {@link Knight} class.
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
     * Constructor initialize knight reference.
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
