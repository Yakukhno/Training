package ua.training.models.knight;

import ua.training.models.ammunition.*;

import java.util.*;

public class Knight implements IKnight {

    Map<String, IAmmunition> ammunition = new HashMap<>();

    public int ammunitionCost() {
        int cost = 0;

        for (IAmmunition x : ammunition.values()) {
            cost += x.getPrice();
        }

        return cost;
    }

    public Set<IAmmunition> sortByWeight() {

        Comparator<IAmmunition> comparator = (IAmmunition o1, IAmmunition o2)
                -> (o1.getWeight() == o2.getWeight())
                ? 0
                : (o1.getWeight() > o2.getWeight()) ? 1 : -1;

        Set<IAmmunition> sortedAmmunition = new TreeSet<>(comparator);
        sortedAmmunition.addAll(ammunition.values());

        return sortedAmmunition;
    }

    public ChainArmor getChainArmor() {
        return (ChainArmor) ammunition.get("chainArmor");
    }

    public void setChainArmor(ChainArmor chainArmor) {
        ammunition.put("chainArmor", chainArmor);
    }

    public Helmet getHelmet() {
        return (Helmet) ammunition.get("helmet");
    }

    public void setHelmet(Helmet helmet) {
        ammunition.put("helmet", helmet);
    }

    public Shield getShield() {
        return (Shield) ammunition.get("shield");
    }

    public void setShield(Shield shield) {
        ammunition.put("shield", shield);
    }

    public Weapon getWeapon() {
        return (Weapon) ammunition.get("weapon");
    }

    public void setWeapon(Weapon weapon) {
        ammunition.put("weapon", weapon);
    }
}
