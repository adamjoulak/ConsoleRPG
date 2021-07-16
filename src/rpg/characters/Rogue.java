package rpg.characters;

import rpg.Exceptions.InvalidWeaponException;
import rpg.attributes.BasePrimaryAttributes;
import rpg.attributes.SecondaryAttribute;
import rpg.attributes.TotalPrimaryAttributes;
import rpg.items.Armor;
import rpg.items.Weapons;

public class Rogue extends Hero{

    private String name;
    private int lvl;
    private int damage;
    private int heroDPS;
    private int vitality;
    private int strength;
    private int dexterity;
    private int intelligence;
    private BasePrimaryAttributes basePrimaryAttributes;
    private TotalPrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttribute secondaryAttribute;
    private Weapons weapons;
    private Armor armor = new Armor();

    public Rogue(String name) {
        this.name = name;
        this.lvl = 1;
        this.basePrimaryAttributes = new BasePrimaryAttributes(8,2,6,1);
        //this.totalPrimaryAttributes = new TotalPrimaryAttributes(5, 1, 1, 8);
        this.secondaryAttribute = new SecondaryAttribute(8,2,6, 1);
        setHealth(8);
    }

    public int getArmorRating(){
        return secondaryAttribute.getArmorRating();
    }

    public void setArmorRating(){
        secondaryAttribute.setArmorRating(getStrength(), getDexterity());
    }

    public int getElementalResistance() {
        return secondaryAttribute.getElementalResistance();
    }

    public void setElementalResistance() {
        secondaryAttribute.setElementalResistance(getIntelligence());
    }

    public int getHealth(){
        return secondaryAttribute.getHealth();
    }
    public void setHealth(int vitality){
        secondaryAttribute.setHealth(vitality);
    }

    @Override
    public int getVitality() {
        return basePrimaryAttributes.getVitality();
    }

    @Override
    public void setVitality(int vitality) {
        basePrimaryAttributes.setVitality(vitality);
    }

    @Override
    public int getStrength() {
        return basePrimaryAttributes.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        basePrimaryAttributes.setStrength(strength);
    }

    @Override
    public int getDexterity() {
        return basePrimaryAttributes.getDexterity();
    }

    @Override
    public void setDexterity(int dexterity) {
        basePrimaryAttributes.setDexterity(dexterity);
    }

    @Override
    public int getIntelligence() {
        return basePrimaryAttributes.getIntelligence();
    }

    @Override
    public void setIntelligence(int intelligence) {
        basePrimaryAttributes.setIntelligence(intelligence);
    }

    @Override
    public BasePrimaryAttributes getBasePrimaryAttributes() {
        return null;
    }

    @Override
    public void setBasePrimaryAttributes() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public int getLvl() {
        return lvl;
    }

    @Override
    public void setLvl(int lvl) {
        if(lvl > 0){
            this.lvl=lvl;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage=damage;
    }

    @Override
    public void setHeroDPS(int allTotalAttributesTogether) {
        heroDPS = weapons.getWeaponDPS()  * (1 + allTotalAttributesTogether/100);
    }

    @Override
    public int getHeroDPS(){
        return heroDPS;
    }

    @Override
    public void setPrimaryAttributes() {

    }

    @Override
    public SecondaryAttribute getSecondaryAttribute() {
        return null;
    }

    @Override
    public void setSecondaryAttribute() {

    }

    @Override
    public void levelUp() {
        setLvl(lvl+1);
        setVitality(basePrimaryAttributes.getVitality() + 3);
        setStrength(basePrimaryAttributes.getStrength() + 1);
        setDexterity(basePrimaryAttributes.getDexterity() + 4);
        setIntelligence(basePrimaryAttributes.getIntelligence() + 1);
        setHealth(basePrimaryAttributes.getVitality());
        setArmorRating();
        setElementalResistance();
        armor.calculateTotalPrimaryAttributes(this);
    }

    @Override
    public void setArmor(Armor.Slot slot, Armor.ArmorType armorType, Hero hero) {
        armor.setArmor(slot, armorType, this);
    }

    public int calculateDamage(){

        return 0;
    }

    public void displayCharacterStats(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: "  + getName() +"\n" +
                "Level: " + getLvl() +"\n" +
                "Strength: " + getStrength() +"\n" +
                "Dexterity: " + getDexterity() +"\n" +
                "Intelligence: " + getIntelligence() +"\n" +
                "Health: " + getHealth() +"\n" +
                "Armor Rating: " + getArmorRating() +"\n" +
                "Elemental Resistance: " + getElementalResistance() +"\n" +
                "DPS: " + getHeroDPS()
        );
        System.out.println(sb);
    }

    public void setWeapon(Weapons.WeaponType weaponType) throws InvalidWeaponException {
        Boolean check = false;
        this.weapons = new Weapons();
        check = weapons.checkIfWeaponCanBeEquipped(this, weaponType, getLvl());
        if (check == true) {
            weapons.equipWeapon(weaponType, weapons, this);
        } else {
            throw new InvalidWeaponException("Invalid weapon"); //Test
        }
    }

    public String getWeaponType(){
        return weapons.getWeaponType();
    }


}
