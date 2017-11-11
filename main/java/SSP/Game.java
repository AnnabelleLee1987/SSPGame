package SSP;

/**
 * Created by anna.rausch on 10.11.17.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * implements Stone, Scissors, Paper game as specified in Readme.md
 */
public class Game {

    private int rounds;
    private int ties;
    private Player playerA;
    private Player playerB;
    private Scanner scanner;


    /**
     * Default empty Constructor
     * */
    public Game(){

    }

    /**
     * calls constructor and gameStart()
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.gameStart();
    }


    /**
     * starts the game
     * plays is depending on user input and
     * prints the results
     */
    private final void gameStart(){
        defineGameSettings();
        playGame();
        printGameResults();
    }

    /**
     * defines the strategies of Player A and Player B
     * and sets the number of game rounds by User Input
     * handle case, that both player choosed stone
     */
    private void defineGameSettings() {
        this.scanner  = new Scanner(System.in);
        boolean bothStone;
        do {
            System.out.println("Setze die Strategie für Spieler A.");
            this.playerA = new Player(getPlayerStrategy());
            System.out.println("Setze die Strategie für Spieler B.");
            this.playerB = new Player(getPlayerStrategy());
            bothStone = playerA.strategy.equals(Strategy.STONE_ALWAYS) && playerB.strategy.equals(Strategy.STONE_ALWAYS);
            if (bothStone) System.out.println("Spielen beide Spieler mit Strategie STEIN IMMER, endet das Spiel nie.");
        } while (bothStone);
        setRoundNumber();
    }


    /**
     * decides for player strategy depending on user input
     * handles invalid Inputs
     */
    private Strategy getPlayerStrategy() {
        Strategy chosenStrategy = null;
        while (chosenStrategy == null) {
            System.out.println("Drücke s für IMMER STEIN oder z für ZUFÄLLIG und bestätige mit ENTER.");
            String userInput = scanner.next();
            if (userInput.equals("s")) {
                chosenStrategy = Strategy.STONE_ALWAYS;
            }
            else if (userInput.equals("z")) {
                chosenStrategy = Strategy.RANDOM;
            }
            else {
                System.out.println("Dies ist eine ungültige Eingabe.");
            }
        }
        return chosenStrategy;
    }

    /**
     * sets number of rounds dependant on user input
     * ends game, if 0 rounds shall be played
     * handles invalid input
     */
    private void setRoundNumber() {
        this.rounds = 0;
        int userInput = 0;
        System.out.println("Wie viele Spielrunden sollen gespielt werden?");
        System.out.println("Gib eine Zahl ein und bestätige mit ENTER.");
        while (userInput == 0) {
            try {
                userInput = scanner.nextInt();
                if (userInput > 0) {
                    this.rounds = userInput;
                }
                else if (userInput == 0) {
                    System.out.println("In dem Spiel werden keine Spielrunden gespielt.");
                    //todo endgame
                } else if (userInput < 0) {
                    System.out.println("Bitte gib eine positive Zahl ein.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Dies ist eine ungültige Eingabe.");
            }
        }
    }


    /**
     * plays the rounds of the game
     */
    private void playGame() {
        this.ties = 0;
        for (int i = 0; i < rounds; i++) {
            int currentRound = i+1;
            playRound(currentRound);
        }
    }


    /**
     * calculates round winner
     * increments the score of the player that wins the round
     * prints round results
     * repeats round in case of a tie
     */
    private void playRound(int currentRound) {
        boolean hasWinner = false;
        while (!hasWinner) {
            System.out.print("Runde :" + currentRound);
            Choice playerAChoice = playerA.makeChoice();
            System.out.print(" Wahl Spieler A: " + playerAChoice);
            Choice playerBChoice = playerB.makeChoice();
            System.out.print(" Wahl Spieler B: " + playerBChoice);
            if (playerAChoice.beats(playerBChoice)) {
                playerA.winsRound();
                System.out.println(" Gewinner: Spieler A:");
                hasWinner = true;
            } else if(playerBChoice.beats(playerAChoice)) {
                playerB.winsRound();
                System.out.println(" Gewinner: Spieler B:");
                hasWinner = true;
            }
            else {
                ties++;
                System.out.println(" Unentschieden. Wiederholung.");
            }
        }
    }


    /**
     * prints the results of the game
     */
    private void printGameResults() {
        System.out.println("\nSpieler A gewann " + playerA.score + " Runden");
        System.out.println("Spieler B gewann " + playerB.score + " Runden");
        System.out.println(ties + " Runde(n) waren unentschieden und mussten wiederholt werden");
    }

}
