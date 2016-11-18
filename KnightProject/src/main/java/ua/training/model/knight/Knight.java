package ua.training.model.knight;

import ua.training.model.knight.ammunition.*;

import java.util.*;
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
    private Map<String, IAmmunition> ammunition = new HashMap<>();

    /**
     * Constructor with package-private access.
     */
    Knight() {}

    /**
     * Returns total cost of ammunition in container.
     * @return total cost of ammunition in container
     */
    public int getAmmunitionCost() {
        int cost = ammunition.values()
                .stream()
                .mapToInt(IAmmunition::getPrice)
                .reduce((s1, s2) -> (s1 + s2))
                .orElse(0);
        return cost;
    }

    /**
     * Sorts container elements by weight in ascending order.
     * @return list, which sorted by weight in ascending order
     */
    public List<IAmmunition> sortAmmunitionByWeight() {
        List<IAmmunition> list = ammunition.values()
                .stream()
                .sorted((o1, o2)
                        -> (o1.getWeight() == o2.getWeight())
                        ? 0
                        : (o1.getWeight() > o2.getWeight()) ? 1 : -1)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * Searches elements in container, which are within the range of price.
     * Barriers of range transmitted in parameters.
     * @param minBarrier minimum barrier of range
     * @param maxBarrier maximum barrier of range
     * @return list with elements, which are within the range of price
     */
    public List<IAmmunition> findInPriceRange(int minBarrier, int maxBarrier) {
        List<IAmmunition> list = ammunition.values()
                .stream()
                .filter(item -> (item.getPrice() < maxBarrier)
                        && (item.getPrice() > minBarrier))
                .collect(Collectors.toList());
        return list;
    }

    //getters & setters

    public ChainArmor getChainArmor() {
        return (ChainArmor) ammunition.get("chainArmor");
    }

    void setChainArmor(ChainArmor chainArmor) {
        ammunition.put("chainArmor", chainArmor);
    }

    public Helmet getHelmet() {
        return (Helmet) ammunition.get("helmet");
    }

    void setHelmet(Helmet helmet) {
        ammunition.put("helmet", helmet);
    }

    public Shield getShield() {
        return (Shield) ammunition.get("shield");
    }

    void setShield(Shield shield) {
        ammunition.put("shield", shield);
    }

    public Weapon getWeapon() {
        return (Weapon) ammunition.get("weapon");
    }

    void setWeapon(Weapon weapon) {
        ammunition.put("weapon", weapon);
    }
}
