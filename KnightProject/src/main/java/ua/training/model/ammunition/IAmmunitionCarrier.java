package ua.training.model.ammunition;

import ua.training.model.product.IProduct;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Interface describes behaviour of some entity, which can operate with
 * {@link ChainArmor}, {@link Helmet}, {@link Shield}, {@link Weapon} objects.
 *
 * @author Ivan Yakuknno
 */
public interface IAmmunitionCarrier {

    /**
     * Returns instance of ChainArmor class.
     * @return instance of ChainArmor class
     */
    ChainArmor getChainArmor();

    /**
     * Returns instance of Helmet class.
     * @return instance of Helmet class
     */
    Helmet getHelmet();

    /**
     * Returns instance of Shield class.
     * @return instance of Shield class
     */
    Shield getShield();

    /**
     * Returns instance of Weapon class.
     * @return instance of Weapon class
     */
    Weapon getWeapon();

    /**
     * Returns total cost of ammunition elements.
     * @return total cost of ammunition elements
     */
    int getAmmunitionCost();

    /**
     * Sorts ammunition elements using comparator.
     * @param comparator sort comparator
     * @return sorted list
     */
    List<IProduct> sort(Comparator<IProduct> comparator);

    /**
     * Searches ammunition elements using predicate.
     * @param predicate condition of searching
     * @return list with elements, which satisfies condition
     */
    List<IProduct> findAmmunition(Predicate<IProduct> predicate);

    Comparator<IProduct> weightAscComparator();

    Predicate<IProduct> ammunitionInPriceRangePredicate(int minBarrier,
                                                        int maxBarrier);
}
