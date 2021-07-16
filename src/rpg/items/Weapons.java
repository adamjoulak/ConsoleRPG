package rpg.items;

import rpg.Exceptions.InvalidWeaponException;
import rpg.characters.*;

public class Weapons extends Items{

    private WeaponType weaponType;
    private int damage;
    private int weaponDPS;

    public enum WeaponType {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND

    }
    public Weapons() {
    }

    public int getWeaponDPS(){
        return weaponDPS;
    }

    public void setWeaponDps(int dexterity, int damage){
        weaponDPS = (dexterity * damage);
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage=damage;
    }

//calcuates bonus damage based on weapons base damage, 1% for every point of
    public int calculateBonusDamage(int x, int damage){
        int temp = x;
        int k = damage;
        for (int i = 0; i < temp; i++) {

            k += (int)(k*(1.0f/100.0f));
        }
            return k;
    }

    public String getWeaponType() {
        return this.weaponType.toString();
    }

    public void equipWeapon(WeaponType weaponType, Weapons weapons, Hero hero){
        try{
            this.weaponType = weaponType;
            if(weaponType == WeaponType.AXE){
                setDamage(7 + calculateBonusDamage(hero.getStrength(), 7));
                setWeaponDps(hero.getDexterity(), getDamage());
            }
            if(weaponType == WeaponType.HAMMER){
                setDamage(10 + calculateBonusDamage(hero.getStrength(), 10));
                setWeaponDps(hero.getDexterity(), getDamage());
            }
            if(weaponType == WeaponType.SWORD){
                if(hero instanceof Rogue){
                    setDamage(13 + calculateBonusDamage(hero.getDexterity(), 13));
                    setWeaponDps(hero.getDexterity(), getDamage());
                }else if(hero instanceof Warrior) {
                    setDamage(13 + calculateBonusDamage(hero.getStrength(), 13));
                    setWeaponDps(hero.getDexterity(), getDamage());
                }
            }
            if(weaponType == WeaponType.DAGGER){
                setDamage(7 + calculateBonusDamage(hero.getDexterity(), 7));
                setWeaponDps(hero.getDexterity(), getDamage());
            }
            if(weaponType == WeaponType.BOW){
                setDamage(7 + calculateBonusDamage(hero.getDexterity(), 7));
                setWeaponDps(hero.getDexterity(), getDamage());
            }
            if(weaponType == WeaponType.STAFF){
                setDamage(7 + calculateBonusDamage(hero.getIntelligence(), 7));
                setWeaponDps(hero.getDexterity(), getDamage());
            }
            if(weaponType == WeaponType.WAND){
                setDamage(7 + calculateBonusDamage(hero.getIntelligence(), 7));
                setWeaponDps(hero.getDexterity(), getDamage());
            }

        }catch (NullPointerException e){
            throw new InvalidWeaponException("Invalid weapon");
        }
    }
    public boolean checkIfWeaponCanBeEquipped(Hero hero, WeaponType weaponType, int level) {
        Boolean check = false;

        if(hero instanceof Mage){
            if(weaponType == WeaponType.STAFF){
                check=true;
            }
            if((weaponType == WeaponType.WAND) && (level > 9)){
                check = true;
            }
        }

        if(hero instanceof Ranger){
            if(weaponType == WeaponType.BOW){
                check = true;
            }
        }

        if(hero instanceof Rogue){
            if(weaponType == WeaponType.DAGGER){
                check = true;
            }
            if((weaponType == WeaponType.SWORD) && (level > 9)){
                check = true;
            }
        }

        if(hero instanceof Warrior){
            if(weaponType == WeaponType.AXE){
                check = true;
            }
            if((weaponType == WeaponType.HAMMER) && (level > 4)){
                check = true;
            }
            if((weaponType == WeaponType.SWORD) && (level > 9)){
                check = true;
            }
        }
        return check;
    }
}
