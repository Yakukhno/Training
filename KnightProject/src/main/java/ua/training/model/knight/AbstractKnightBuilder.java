package ua.training.model.knight;

import ua.training.model.knight.ammunition.ChainArmor;
import ua.training.model.knight.ammunition.Shield;
import ua.training.model.knight.ammunition.Weapon;

public abstract class AbstractKnightBuilder {

    protected Knight knight;

    protected AbstractKnightBuilder() {
        knight = new Knight();
    }

    public abstract KnightBuilder buildChainArmor(ChainArmor.ChainArmorMaterial material);
    public abstract KnightBuilder buildShield(Shield.ShieldMaterial material, Shield.Shape shape);
    public abstract KnightBuilder buildWeapon(Weapon.WeaponType type);
    public abstract KnightBuilder buildHelmet(boolean isProtectedFace);

    public Knight build() {
        return knight;
    }

}
