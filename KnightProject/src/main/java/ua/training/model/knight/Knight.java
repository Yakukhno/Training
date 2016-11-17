package ua.training.model.knight;

import ua.training.model.knight.ammunition.*;

import java.util.*;
import java.util.stream.Collectors;

public class Knight implements IAmmunitionCarrier {

    private Map<String, IAmmunition> ammunition = new HashMap<>();

    public int getAmmunitionCost() {
        int cost = ammunition.values()
                .stream()
                .mapToInt(IAmmunition::getPrice)
                .reduce((s1, s2) -> (s1 + s2))
                .orElse(0);
        return cost;
    }

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

    public List<IAmmunition> findInPriceRange(int minBarrier, int maxBarrier) {
        List<IAmmunition> list = ammunition.values()
                .stream()
                .filter(item -> (item.getPrice() < maxBarrier)
                        && (item.getPrice() > minBarrier))
                .collect(Collectors.toList());
        return list;
    }

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
