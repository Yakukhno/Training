package ua.training.model.knight;

import ua.training.model.knight.ammunition.*;

import java.util.List;

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
     * Sorts ammunition elements by weight in ascending order.
     * @return list, which sorted by weight in ascending order
     */
    List<IAmmunition> sortAmmunitionByWeight();

    /**
     * Searches ammunition elements, which are within the range of price.
     * Barriers of range transmitted in parameters.
     * @param minBarrier minimum barrier of range
     * @param maxBarrier maximum barrier of range
     * @return list with elements, which are within the range of price
     */
    List<IAmmunition> findInPriceRange(int minBarrier, int maxBarrier);

}
