package ua.training.models.knight;

import ua.training.models.ammunition.*;

import java.util.*;

public class Knight implements IKnight {

    private Map<String, IAmmunition> ammunition = new HashMap<>();

    public int ammunitionCost() {
        int cost = 0;

        for (IAmmunition x : ammunition.values()) {
            cost += x.getPrice();
        }

        return cost;
    }

    public List<IAmmunition> sortByWeight() {

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
