package rpg.attributes;

public class TotalPrimaryAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;
    private int headBonusAttribute;
    private int bodyBonusAttribute;
    private int legsBonusAttribute;
    private int allAttributesTogether;

    public TotalPrimaryAttributes(int str, int dex, int intel, int vit, int headBonusAttribute, int bodyBonusAttribute, int legsBonusAttribute) {
        this.strength = str;
        this.dexterity = dex;
        this.intelligence = intel;
        this.vitality = vit;
        this.headBonusAttribute = headBonusAttribute;
        this.bodyBonusAttribute = bodyBonusAttribute;
        this.legsBonusAttribute = legsBonusAttribute;
        allAttributesTogether = (str+dex+intel+vit+headBonusAttribute+bodyBonusAttribute+legsBonusAttribute);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getHeadBonusAttribute() {
        return headBonusAttribute;
    }

    public void setHeadBonusAttribute(int headBonusAttribute) {
        this.headBonusAttribute = headBonusAttribute;
    }

    public int getBodyBonusAttribute() {
        return bodyBonusAttribute;
    }

    public void setBodyBonusAttribute(int bodyBonusAttribute) {
        this.bodyBonusAttribute = bodyBonusAttribute;
    }

    public int getLegsBonusAttribute() {
        return legsBonusAttribute;
    }

    public void setLegsBonusAttribute(int legsBonusAttribute) {
        this.legsBonusAttribute = legsBonusAttribute;
    }

    public int getAllAttributesTogether() {
        return allAttributesTogether;
    }


}
