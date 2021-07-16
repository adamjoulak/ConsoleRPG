import org.junit.jupiter.api.Test;
import rpg.characters.Mage;
import rpg.characters.Ranger;
import rpg.characters.Rogue;
import rpg.characters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterAndAttributeTests {

    @Test
    void getLvl_checkIfHeroIsLevel1_1(){
        Mage m = new Mage("test");
        assertEquals(1,m.getLvl());
    }

    @Test
    void levelUp_checkIfHeroIsLevel2AfterLevelUp_2(){
        Mage m = new Mage("test");
        m.levelUp();
        assertEquals(2,m.getLvl());
    }

     @Test
    void setLvl_TryToGain0orLessLevels_argumentException(){
        Mage m = new Mage("test");
        assertThrows(IllegalArgumentException.class, ()->m.setLvl(0));

    }

    @Test
    void newMage_checkIfProperAttributesWhenCreated_5118(){
        Mage m = new Mage("test");
        assertEquals(5,m.getVitality());
        assertEquals(1,m.getStrength());
        assertEquals(1,m.getDexterity());
        assertEquals(8,m.getIntelligence());
    }
    @Test
    void newRanger_checkIfProperAttributesWhenCreated_8171(){
        Ranger m = new Ranger("test");
        assertEquals(8,m.getVitality());
        assertEquals(1,m.getStrength());
        assertEquals(7,m.getDexterity());
        assertEquals(1,m.getIntelligence());
    }
    @Test
    void newRogue_checkIfProperAttributesWhenCreated_8261(){
        Rogue m = new Rogue("test");
        assertEquals(8,m.getVitality());
        assertEquals(2,m.getStrength());
        assertEquals(6,m.getDexterity());
        assertEquals(1,m.getIntelligence());
    }
    @Test
    void newWarrior_checkIfProperAttributesWhenCreated_10521(){
        Warrior m = new Warrior("test");
        assertEquals(10,m.getVitality());
        assertEquals(5,m.getStrength());
        assertEquals(2,m.getDexterity());
        assertEquals(1,m.getIntelligence());
    }
    @Test
    void levelupMage_checkIfProperAttributesWhenLevelUp_82213(){
        Mage m = new Mage("test");
        m.levelUp();
        assertEquals(8,m.getVitality());
        assertEquals(2,m.getStrength());
        assertEquals(2,m.getDexterity());
        assertEquals(13,m.getIntelligence());
    }
    @Test
    void levelupRanger_checkIfProperAttributesWhenLevelUp_102122(){
        Ranger m = new Ranger("test");
        m.levelUp();
        assertEquals(10,m.getVitality());
        assertEquals(2,m.getStrength());
        assertEquals(12,m.getDexterity());
        assertEquals(2,m.getIntelligence());
    }
    @Test //FIXA
    void levelUpRogue_checkIfProperAttributesWhenLevelUp_113102(){
        Rogue m = new Rogue("test");
        m.levelUp();
        assertEquals(11,m.getVitality());
        assertEquals(3,m.getStrength());
        assertEquals(10,m.getDexterity());
        assertEquals(2,m.getIntelligence());

    }
    @Test
    void levelUpWarrior_checkIfProperAttributesWhenLevelUp_15842(){
        Warrior m = new Warrior("test");
        m.levelUp();
        assertEquals(15,m.getVitality());
        assertEquals(8,m.getStrength());
        assertEquals(4,m.getDexterity());
        assertEquals(2,m.getIntelligence());
    }
    @Test
    void levelupWarrior_checkIfSecondaryStatsLevelUp_150122(){
        Warrior m = new Warrior("test");
        m.levelUp();
        assertEquals(150,m.getHealth());
        assertEquals(12,m.getArmorRating());
        assertEquals(2, m.getElementalResistance());
    }
}
