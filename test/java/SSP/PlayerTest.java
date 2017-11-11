package SSP;

/**
 * Created by anna.rausch on 10.11.17.
 */

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for Player class
 */
public class PlayerTest {

    /**
     * default empty constructor.
     */
    public PlayerTest() {

    }

    /**
     * test method for makeChoice() method in Player
     * test case: Player Strategy is STONE_ALWAYS
     */
    @Test
    public void testMakeChoiceStone() {
        Player player = new Player(Strategy.STONE_ALWAYS);
        Assert.assertEquals(Choice.STONE, player.makeChoice());
    }

    /**
     * test method for makeChoice() method in Player
     * test case: Player Strategy is RANDOM
     */
    @Test
    public void testMakeChoiceRandom() {
        Player player = new Player(Strategy.RANDOM);
        Assert.assertNotNull(player.makeChoice());
    }

    /**
     * test method for winsRound() method in Player
     * test cases:
     * Player is initialzed (score must be null)
     * Player wins round (score must be incremented)
     */
    @Test
    public void testWinsRound() {
        Player player = new Player(Strategy.RANDOM);
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(player.score == i);
            player.winsRound();
        }
    }

}
