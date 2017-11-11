package SSP;

import java.util.Random;

/**
 * Created by anna.rausch on 10.11.17.
 */

/**
 * Enum class Strategy defines strategies (STONE_ALWAYS, RANDOM) for a player.
 * Each strategy corresponds to a way the choice of a player is made.
 */
public enum Strategy {
    STONE_ALWAYS, RANDOM;

    private final Choice[] choices = Choice.values();

    /**
     * method resultsInChoice() STONE for Strategy ALWAYS_STONE and random Choice per default.
     * @return Choice of the player in the Round
     */
    Choice resultsInChoice() {
        switch (this) {
            case STONE_ALWAYS:
                return Choice.STONE;
            default:
                Random random = new Random();
                int index = random.nextInt(choices.length);
                return choices[index];
        }
    }
}
