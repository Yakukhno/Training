package ua.training;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.knight.ammunition.*;
import ua.training.model.knight.IAmmunitionCarrier;
import ua.training.model.knight.Knight;
import ua.training.model.knight.KnightBuilder;

import java.util.List;

import static org.junit.Assert.*;

public class KnightTest {

    private IAmmunitionCarrier knight;

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

        assertEquals(knight.getAmmunitionCost(), knight.getChainArmor().getPrice()
                + knight.getHelmet().getPrice() + knight.getShield().getPrice()
                + knight.getWeapon().getPrice());

        knight = new KnightBuilder().build();

        assertEquals(knight.getAmmunitionCost(), 0);
    }

    @Test
    public void testSortByWeight() {
        knight = new KnightBuilder()
                .buildChainArmor(ChainArmor.ChainArmorMaterial.STEAL)
                .buildHelmet(false)
                .buildShield(Shield.ShieldMaterial.COPPER, Shield.Shape.SQUARE)
                .buildWeapon(Weapon.WeaponType.SWORD)
                .build();

        List<IAmmunition> ammunitionList = knight.sortAmmunitionByWeight();

        boolean isSorted = true;
        for (int i = 0; i < ammunitionList.size() - 1; i++) {
            if (ammunitionList.get(i).getWeight()
                    > ammunitionList.get(i + 1).getWeight()) {
                isSorted = false;
                break;
            }
        }
        assertTrue(isSorted);
    }

    @Test
    public void testFindInPriceRange() {
        knight = new KnightBuilder()
                .buildChainArmor(ChainArmor.ChainArmorMaterial.STEAL)
                .buildHelmet(false)
                .buildShield(Shield.ShieldMaterial.COPPER, Shield.Shape.SQUARE)
                .buildWeapon(Weapon.WeaponType.SWORD)
                .build();

        int minBarrier = 30;
        int maxBarrier = 220;
        List<IAmmunition> ammunitionList = knight.findInPriceRange(minBarrier, maxBarrier);

        boolean isTrueSearch = true;
        for (int i = 0; i < ammunitionList.size(); i++) {
            if ((ammunitionList.get(i).getPrice() > maxBarrier)
                    || (ammunitionList.get(i).getPrice() < minBarrier)) {
                isTrueSearch = false;
                break;
            }
        }
        assertTrue(isTrueSearch);
    }

}
