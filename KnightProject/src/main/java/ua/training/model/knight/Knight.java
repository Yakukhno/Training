package ua.training.model.knight;

import ua.training.model.knight.ammunition.*;

import java.util.*;

public class Knight implements IAmmunitionCarrier {

    private Map<String, IAmmunition> ammunition = new HashMap<>();

    public int getAmmunitionCost() {
        int cost = 0;

        for (IAmmunition x : ammunition.values()) {
            cost += x.getPrice();
        }

        return cost;
    }

    public List<IAmmunition> sortAmmunitionByWeight() {

        Comparator<IAmmunition> comparator = (IAmmunition o1, IAmmunition o2)
                -> (o1.getWeight() == o2.getWeight())
                ? 0
                : (o1.getWeight() > o2.getWeight()) ? 1 : -1;

        Collection<IAmmunition> collection = ammunition.values();
        List<IAmmunition> list = new ArrayList<>();
        list.addAll(collection);
        Collections.sort(list, comparator);

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
