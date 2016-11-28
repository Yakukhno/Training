package ua.training.model.knight;

import ua.training.model.ammunition.*;
import ua.training.model.product.IProduct;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementation of <tt>IAmmunitionCarrier</tt> interface, which presents knight.
 * Class contains collection of ammunition and methods to work with it.
 * To create instance of this class use {@link KnightBuilder}.
 *
 * @author Ivan Yakukhno
 * @see IAmmunitionCarrier
 * @see KnightBuilder
 */

public class Knight implements IAmmunitionCarrier {

    /**
     * Container of ammunition.
     */
    private Map<AmmunitionEnum, IProduct> ammunition = new HashMap<>();

    /**
     * Constructor with package-private access.
     */
    Knight() {}

    /**
     * Returns total cost of ammunition in container.
     * @return total cost of ammunition in container
     */
    public int getAmmunitionCost() {
        return ammunition.values()
                .stream()
                .mapToInt(IProduct::getPrice)
                .reduce((s1, s2) -> (s1 + s2))
                .orElse(0);
    }

    /**
     * Sorts ammunition elements using comparator.
     * @param comparator sort comparator
     * @return sorted list
     */
    public List<IProduct> sort(Comparator<IProduct> comparator) {
        return ammunition.values()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Searches ammunition elements using predicate.
     * @param predicate condition of searching
     * @return list with elements, which satisfies condition
     */
    public List<IProduct> findAmmunition(Predicate<IProduct> predicate) {
        return ammunition.values()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Comparator<IProduct> weightAscComparator() {
        return (o1, o2) -> (o1.getWeight() == o2.getWeight())
                ? 0
                : (o1.getWeight() > o2.getWeight()) ? 1 : -1;
    }

    public Predicate<IProduct> ammunitionInPriceRangePredicate(
            int minBarrier, int maxBarrier) {
        return item -> (item.getPrice() < maxBarrier)
                && (item.getPrice() > minBarrier);
    }

    //getters & setters

    public ChainArmor getChainArmor() {
        return (ChainArmor) ammunition.get(AmmunitionEnum.CHAIN_ARMOR);
    }

    void setChainArmor(ChainArmor chainArmor) {
        ammunition.put(AmmunitionEnum.CHAIN_ARMOR, chainArmor);
    }

    public Helmet getHelmet() {
        return (Helmet) ammunition.get(AmmunitionEnum.HELMET);
    }

    void setHelmet(Helmet helmet) {
        ammunition.put(AmmunitionEnum.HELMET, helmet);
    }

    public Shield getShield() {
        return (Shield) ammunition.get(AmmunitionEnum.SHIELD);
    }

    void setShield(Shield shield) {
        ammunition.put(AmmunitionEnum.SHIELD, shield);
    }

    public Weapon getWeapon() {
        return (Weapon) ammunition.get(AmmunitionEnum.WEAPON);
    }

    void setWeapon(Weapon weapon) {
        ammunition.put(AmmunitionEnum.WEAPON, weapon);
    }

    public enum AmmunitionEnum {
        CHAIN_ARMOR, HELMET, SHIELD, WEAPON
    }
}
