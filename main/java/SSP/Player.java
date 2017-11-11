package SSP;

/**
 * Created by anna.rausch on 10.11.17.
 */

/**
 * Class Player has a Strategy and can make a Choice
 */
public class Player {

    public final Strategy strategy;
    public int score;

    /**
     * Constructor and Initialization of strategy
     * @param strategy
     */
    public Player(Strategy strategy) {
        this.strategy = strategy;
        this.score = 0;
    }

    /**
     * makes a Choice depending of the Players Strategy
     * @return Choice of the Player made in a Round
     */
    public final Choice makeChoice(){
        Choice choice = this.strategy.resultsInChoice();
        return choice;
    }

    /**
     * increments score of the player
     */
    public boolean winsRound(){
        this.score++;
        return true;
    }
}
