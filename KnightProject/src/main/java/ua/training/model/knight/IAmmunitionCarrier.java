package ua.training.model.knight;

import ua.training.model.knight.ammunition.*;

import java.util.List;

public interface IAmmunitionCarrier {

    ChainArmor getChainArmor();
    Helmet getHelmet();
    Shield getShield();
    Weapon getWeapon();
    int getAmmunitionCost();
    List<IAmmunition> sortAmmunitionByWeight();
    List<IAmmunition> findInPriceRange(int minBarrier, int maxBarrier);

}
