import org.junit.jupiter.api.Test;
import rpg.Exceptions.InvalidArmorException;
import rpg.Exceptions.InvalidWeaponException;
import rpg.characters.Ranger;
import rpg.characters.Warrior;
import rpg.items.Armor;
import rpg.items.Weapons;

import static org.junit.jupiter.api.Assertions.*;

public class ItemsAndEquipmentTest {

    @Test //I set sword instead of axe because i set sword as a higher level weapon
        // and Axe can be equipped at level 1, im sorry for misreading the instructions
    void equipWeapon_tryEquipHighLevelWeapon_InvalidWeaponException(){
        Warrior m = new Warrior("test");
        assertThrows(InvalidWeaponException.class, ()->m.setWeapon(Weapons.WeaponType.SWORD));
    }

    @Test //I dont set level as last test because i have made presets levels for all items,
        // im sorry for misreading the instructions
    void equipArmor_tryEquipHighLevelArmor_InvalidArmorException(){
        Warrior m = new Warrior("test");
        assertThrows(InvalidArmorException.class, ()->m.setArmor(Armor.Slot.BODY, Armor.ArmorType.PLATE,m));
    }

    @Test
    void equipWeapon_TryEquippingWrongTypeOfWeapon_InvalidWeaponException(){
        Warrior m = new Warrior("test");
        assertThrows(InvalidWeaponException.class, ()->m.setWeapon(Weapons.WeaponType.BOW));
    }

    @Test
    void equipArmor_TryEquippingWrongTypeOfArmor_InvalidArmorException(){
        Warrior m = new Warrior("test");
        assertThrows(InvalidArmorException.class, ()->m.setArmor(Armor.Slot.BODY, Armor.ArmorType.CLOTH,m));
    }

    @Test
    void checkIfWeaponCanBeEquipped_TryEquipValidWeapon_true(){
        Warrior m = new Warrior("test");
        Weapons w = new Weapons();
        assertTrue(w.checkIfWeaponCanBeEquipped(m, Weapons.WeaponType.SWORD,10));
    }





    }
