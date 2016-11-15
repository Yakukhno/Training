package ua.training.models.knight;

import ua.training.models.ammunition.*;

import java.util.Set;

public interface IKnight {

    ChainArmor getChainArmor();
    void setChainArmor(ChainArmor chainArmor);
    Helmet getHelmet();
    void setHelmet(Helmet helmet);
    Shield getShield();
    void setShield(Shield shield);
    Weapon getWeapon();
    void setWeapon(Weapon weapon);
    int ammunitionCost();
    Set<IAmmunition> sortByWeight();

}
