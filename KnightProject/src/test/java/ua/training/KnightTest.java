package ua.training;

import org.junit.Before;
import org.junit.Test;
import ua.training.models.ammunition.*;
import ua.training.models.knight.IKnight;
import ua.training.models.knight.Knight;
import ua.training.models.knight.KnightBuilder;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class KnightTest {

    private IKnight knight;

    @Before
    public void before() {
        knight = new Knight();
    }

    @Test
    public void testAmmunitionCost() {

        knight = new KnightBuilder()
                .buildChainArmor(ChainArmor.ChainArmorMaterial.STEAL)
                .buildHelmet(false)
                .buildShield(Shield.ShieldMaterial.WOOD, Shield.Shape.SQUARE)
                .buildWeapon(Weapon.WeaponType.SWORD)
                .build();

        assertEquals(knight.ammunitionCost(), knight.getChainArmor().getPrice()
                + knight.getHelmet().getPrice() + knight.getShield().getPrice()
                + knight.getWeapon().getPrice());

    }

    @Test
    public void testSortByWeight() {

        ChainArmor chainArmor = new ChainArmor(200, 23,
                ChainArmor.ChainArmorMaterial.STEAL);
        Helmet helmet = new Helmet(80, 4, false);
        Shield shield = new Shield(100, 3, Shield.ShieldMaterial.WOOD,
                Shield.Shape.SQUARE);
        Weapon weapon = new Weapon(150, 10, Weapon.WeaponType.SWORD);

        IAmmunition[] ammunitionArray = new IAmmunition[] {
                shield, helmet, weapon, chainArmor
        };

        knight.setChainArmor(chainArmor);
        knight.setWeapon(weapon);
        knight.setHelmet(helmet);
        knight.setShield(shield);

        List<IAmmunition> setAmmunition = knight.sortByWeight();

        assertArrayEquals(setAmmunition.toArray(), ammunitionArray);
    }

}
