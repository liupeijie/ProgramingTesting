package step;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liupeijie on 西暦15/06/23.
 */
public class RollDiceTest {
    @Test
    public void testRollDice(){

      /*  assertTrue(RollDice.rollDice(1000000,1));
        assertTrue(RollDice.rollDice(1000000,2));
        assertTrue(RollDice.rollDice(1000000,3));
        assertTrue(RollDice.rollDice(1000000,4));
        assertTrue(RollDice.rollDice(1000000,5));
        assertTrue(RollDice.rollDice(1000000,6));*/

        assertTrue(RollDice.rollDice(10000000,1));
        assertTrue(RollDice.rollDice(10000000,2));
        assertTrue(RollDice.rollDice(10000000,3));
        assertTrue(RollDice.rollDice(10000000,4));
        assertTrue(RollDice.rollDice(10000000,5));
        assertTrue(RollDice.rollDice(10000000,6));

        assertTrue(RollDice.checkRollDice(10000000, 1));
        assertTrue(RollDice.checkRollDice(10000000, 2));
        assertTrue(RollDice.checkRollDice(10000000, 3));
        assertTrue(RollDice.checkRollDice(10000000, 4));
        assertTrue(RollDice.checkRollDice(10000000,5));
        assertTrue(RollDice.checkRollDice(10000000,6));
    }

}