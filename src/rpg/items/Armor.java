package rpg.items;

import rpg.Exceptions.InvalidArmorException;
import rpg.attributes.TotalPrimaryAttributes;
import rpg.characters.*;

import java.util.HashMap;

public class Armor extends Items{
    private HashMap<Slot, ArmorType> armorHashMap = new HashMap<Slot, ArmorType>();
    private int headBonusAttribute;
    private int bodyBonusAttribute;
    private int legsBonusAttribute;
    private TotalPrimaryAttributes totalPrimaryAttributes;

    public enum Slot {
        HEAD,
        BODY,
        LEGS
    }

    public enum ArmorType{
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    public Armor(){

    }

    public void setBodyBonusAttribute(int bodyBonusAttribute) {
        this.bodyBonusAttribute = bodyBonusAttribute;
    }

    public int getBodyBonusAttribute() {
        return bodyBonusAttribute;
    }

    public void setHeadBonusAttribute(int headBonusAttribute) {
        this.headBonusAttribute = headBonusAttribute;
    }

    public int getHeadBonusAttribute(){
        return headBonusAttribute;
    }

    public void setLegsBonusAttribute(int legsBonusAttribute) {
        this.legsBonusAttribute = legsBonusAttribute;
    }

    public int getLegsBonusAttribute() {
        return legsBonusAttribute;
    }

    public void setBonusAttribute(Slot slot, int bonus){
        if(slot == Slot.HEAD) {
            this.headBonusAttribute = bonus;
        }
        if(slot == Slot.BODY) {
            this.bodyBonusAttribute = (bonus + 2);
        }
        if(slot == Slot.LEGS){
            this.legsBonusAttribute = (bonus + 1);
        }
    }

    public boolean setArmor(Slot slot, ArmorType armorType, Hero hero){
        boolean check = false;
        if((hero instanceof Mage) && (armorType == ArmorType.CLOTH)){

            armorHashMap.put(slot, armorType);
            setBonusAttribute(slot, 3);
            calculateTotalPrimaryAttributes(hero);
            check = true;
        }else if((hero instanceof Mage) && (armorType != ArmorType.CLOTH)){
            throw new InvalidArmorException("Armor cannot be equipped");
        }
        if((hero instanceof Ranger) && ((armorType == ArmorType.LEATHER) || (armorType == ArmorType.MAIL))){
            if(checkIfArmorCanBeEquipped(hero, armorType, hero.getLvl()) == true) {
                armorHashMap.remove(slot, ArmorType.LEATHER);
                armorHashMap.remove(slot, ArmorType.MAIL);
                armorHashMap.put(slot, armorType);
                if(armorType==ArmorType.LEATHER){
                    setBonusAttribute(slot, 3);
                    calculateTotalPrimaryAttributes(hero);
                    check = true;
                }
                if(armorType==ArmorType.MAIL){
                    setBonusAttribute(slot, 5);
                    calculateTotalPrimaryAttributes(hero);
                    check = true;
                }
                System.out.println(armorHashMap.toString() + "<--- works?");
            }
        }else if((hero instanceof Ranger) && ((armorType != ArmorType.LEATHER) || (armorType != ArmorType.MAIL))){
            throw new InvalidArmorException("Armor cannot be equipped");
        }

        if((hero instanceof Rogue) && ((armorType == ArmorType.LEATHER) || (armorType == ArmorType.MAIL))){
            if(checkIfArmorCanBeEquipped(hero, armorType, hero.getLvl()) == true) {
                armorHashMap.remove(slot, ArmorType.LEATHER);
                armorHashMap.remove(slot, ArmorType.MAIL);
                armorHashMap.put(slot, armorType);
                if(armorType==ArmorType.LEATHER){
                    setBonusAttribute(slot, 3);
                    calculateTotalPrimaryAttributes(hero);
                    check = true;
                }
                if(armorType==ArmorType.MAIL){
                    setBonusAttribute(slot, 5);
                    calculateTotalPrimaryAttributes(hero);
                    check = true;
                }
            }else{
                }
        }else if((hero instanceof Rogue) && ((armorType != ArmorType.LEATHER) || (armorType != ArmorType.MAIL))){
            throw new InvalidArmorException("Armor cannot be equipped");
        }
        if((hero instanceof Warrior) && ((armorType == ArmorType.MAIL) || (armorType == ArmorType.PLATE))){ if(checkIfArmorCanBeEquipped(hero, armorType, hero.getLvl()) == true) {
            armorHashMap.remove(slot, ArmorType.PLATE);
            armorHashMap.remove(slot, ArmorType.MAIL);
            armorHashMap.put(slot, armorType);
            if(armorType==ArmorType.PLATE){
                setBonusAttribute(slot, 5);
                calculateTotalPrimaryAttributes(hero);
                check = true;
            }
            if(armorType==ArmorType.MAIL){
                setBonusAttribute(slot, 3);
                calculateTotalPrimaryAttributes(hero);
                check = true;
            }
        }
        }else if((hero instanceof Warrior) && ((armorType != ArmorType.MAIL) || (armorType != ArmorType.PLATE))){
                throw new InvalidArmorException("Armor cannot be equipped");
            }
        return check;
    }

    public boolean checkIfArmorCanBeEquipped(Hero hero, ArmorType armorType, int level){
        boolean check = false;
        if(hero instanceof Ranger){
            if(armorType == ArmorType.LEATHER){
                check = true;
            }
            if((armorType == ArmorType.MAIL) && (level > 4)){
                check = true;
            }
        }
        if(hero instanceof Rogue){
            if(armorType == ArmorType.LEATHER){ check = true;
            }
            if((armorType == ArmorType.MAIL) && (level > 4)){
                check = true;
            }
        }
        if(hero instanceof Warrior){
            if(armorType == ArmorType.MAIL){
                check = true;
            }
            if((armorType == ArmorType.PLATE) && (level > 4)){
                check = true;
            }
        }
        return check;
    }

    public String getHashValuesFrom(){
        return armorHashMap.toString();

    }

    public void calculateTotalPrimaryAttributes(Hero hero) {
        if(totalPrimaryAttributes == null){
            totalPrimaryAttributes = new TotalPrimaryAttributes(hero.getStrength(),hero.getDexterity(),hero.getIntelligence(),hero.getVitality(),
                    getHeadBonusAttribute(), getBodyBonusAttribute(),getLegsBonusAttribute());
        }else{
            totalPrimaryAttributes.setStrength(hero.getStrength());
            totalPrimaryAttributes.setDexterity(hero.getDexterity());
            totalPrimaryAttributes.setIntelligence(hero.getIntelligence());
            totalPrimaryAttributes.setVitality(hero.getVitality());
            totalPrimaryAttributes.setHeadBonusAttribute(getHeadBonusAttribute());
            totalPrimaryAttributes.setBodyBonusAttribute(getBodyBonusAttribute());
            totalPrimaryAttributes.setLegsBonusAttribute(getLegsBonusAttribute());
        }
    }
}
