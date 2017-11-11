package SSP;

/**
 * Created by anna.rausch on 10.11.17.
 */

/**
 * Enum class Choice defines choices (STONE, SCISSORS, PAPER) of a player.
 * Each choice corresponds to another choice, which is beaten by it.
 */
public enum Choice {
    STONE, SCISSORS, PAPER;

    /**
     * returns true, if the player beats the other with its choice and false, if not
     * @throws IllegalStateException if enum Choice is extended with a constant and no case in beats is defined for it
     * @param otherChoice is the Choice of the other Player
     * @return boolean
     */
    boolean beats(Choice otherChoice) {
        switch (this) {
            case STONE:
                return otherChoice.equals(SCISSORS);
            case PAPER:
                return otherChoice.equals(STONE);
            case SCISSORS:
                return otherChoice.equals(PAPER);
            default:
                throw new IllegalStateException();
        }
    }
}
