package rpg.characters;

import rpg.attributes.BasePrimaryAttributes;
import rpg.attributes.TotalPrimaryAttributes;
import rpg.attributes.SecondaryAttribute;
import rpg.items.Armor;
import rpg.items.Weapons;

import java.util.List;

public abstract class Hero {
    private String name;
    private int lvl;
    private int damage;
    private List<Weapons> weapons;

    private int vitality;
    private int strength;
    private int dexterity;
    private int intelligence;

    private BasePrimaryAttributes basePrimaryAttributes;
    private TotalPrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttribute secondaryAttribute;

    abstract public int getVitality();

    abstract public void setVitality(int vitality);

    abstract public int getStrength();

    abstract public void setStrength(int strength);

    abstract public int getDexterity();

    abstract public void setDexterity(int dexterity);

    abstract public int getIntelligence();

    abstract public void setIntelligence(int intelligence);

    abstract public BasePrimaryAttributes getBasePrimaryAttributes();

    abstract public void setBasePrimaryAttributes();

    abstract public String getName();

    abstract public void setName(String name);

    abstract public int getLvl();

    abstract public void setLvl(int lvl);

    abstract public int getDamage();

    abstract public void setDamage(int damage);

    abstract public void setHeroDPS(int allTotalAttributesTogether);

    abstract public int getHeroDPS();

    abstract public void setPrimaryAttributes();

    abstract public SecondaryAttribute getSecondaryAttribute();

    abstract public void setSecondaryAttribute();

    abstract public void levelUp();

    public abstract void setArmor(Armor.Slot slot, Armor.ArmorType armorType, Hero hero);

    //abstract public void setHeroDps(int attribute, int damage);
}
