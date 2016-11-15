package ua.training.models;

import ua.training.models.ammunition.ChainArmor;
import ua.training.models.ammunition.Helmet;
import ua.training.models.ammunition.Shield;
import ua.training.models.ammunition.Weapon;

public interface IKnight {

    ChainArmor getChainArmor();
    void setChainArmor(ChainArmor chainArmor);
    Helmet getHelmet();
    void setChainArmor(Helmet helmet);
    Shield getShield();
    void setShield(Shield shield);
    Weapon getWeapon();
    void setWeapon(Weapon weapon);

}
