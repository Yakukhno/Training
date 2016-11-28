package ua.training;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.ammunition.*;
import ua.training.model.ammunition.IAmmunitionCarrier;
import ua.training.model.knight.Knight;
import ua.training.model.knight.KnightBuilder;
import ua.training.model.product.IProduct;

import java.util.List;

import static org.junit.Assert.*;

public class KnightTest {

    private IAmmunitionCarrier knight;

    @Before
    public void before() {
        knight = new KnightBuilder()
                .buildChainArmor(ChainArmor.ChainArmorMaterial.STEAL)
                .buildHelmet(false)
                .buildShield(Shield.ShieldMaterial.COPPER, Shield.Shape.SQUARE)
                .buildWeapon(Weapon.WeaponType.SWORD)
                .build();
    }

    @Test
    public void testAmmunitionCost() {
        assertEquals(knight.getAmmunitionCost(), knight.getChainArmor().getPrice()
                + knight.getHelmet().getPrice() + knight.getShield().getPrice()
                + knight.getWeapon().getPrice());

        knight = new KnightBuilder().build();
        assertEquals(knight.getAmmunitionCost(), 0);
    }

    @Test
    public void testSortByWeight() {
        List<IProduct> ammunitionList = knight.sort(knight.weightAscComparator());

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
        int minBarrier = 30;
        int maxBarrier = 220;
        List<IProduct> ammunitionList = knight.findAmmunition(
                knight.ammunitionInPriceRangePredicate(minBarrier, maxBarrier));

        boolean isIncorrectSearch = ammunitionList
                .stream()
                .allMatch(item -> (item.getPrice() > maxBarrier)
                    || (item.getPrice() < minBarrier));
        assertFalse(isIncorrectSearch);
    }

}
