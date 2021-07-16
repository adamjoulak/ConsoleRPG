package rpg.attributes;

public class SecondaryAttribute {
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttribute(int vitality, int strength, int dexterity, int intelligence) {
        this.health = vitality * 10;
        this.armorRating = strength + dexterity;
        this.elementalResistance = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int vitality) {
        this.health = vitality * 10;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int strength, int dexterity) {
        this.armorRating = strength + dexterity;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    public void setElementalResistance(int intelligence) {
        this.elementalResistance = intelligence;
    }
}
