package c.mariage;


import c.mariage.util.Difficulty;
import c.mariage.util.Input;

public class GameManager {

    /**
     * The grid for the game. Contains an instantiation of the Grid object once startGame() has been called. Contains null otherwise.
     */
    private Grid grid;

    /**
     * The chosen difficulty, affecting the time of a match.
     */
    private Difficulty chosenDifficulty;


    /**
     * Colours used in the terminal for better visual.
     */
    private static final String WARNING_COLOUR = "\u001B[38;2;181;9;9m";
    protected static final String RESET_COLOUR = "\u001B[0m";
    protected static final String GRID_COLOUR = "\u001B[48;2;160;160;160m\u001B[30m";
    protected static final String TIMER_OFF_COLOUR = "\u001B[48;2;160;160;160m\u001B[38;2;181;9;9m";

    /**
     * Constructor.
     */
    public GameManager(){
        this.grid = new Grid();
        this.chosenDifficulty =  this.chooseDifficulty();
    }

    /**
     * Asks the user for the difficulty of the game. A higher difficulty means less time on the timer.
     * @return the number corresponding to the chosen difficulty
     */
    public Difficulty chooseDifficulty(){

        // shows the items until the user made a valid choice
        int choice = -1;
        while ((choice < 0) || (choice > Difficulty.values().length)) {
            System.out.println("Please chose the difficulty of the game:");
            int index = 1;

            for (Difficulty diff : Difficulty.values()) {
                System.out.println("  " + (index++) + " - " + diff.toString()+" ("+diff.getMinutes()+" minutes)");
            }
            System.out.println("  Choose 0 to return to the Menu.\n");
            System.out.println("*_____ What is your choice ? _____*");

            try {
                choice = Input.readInt();
            } catch (java.io.IOException e) {
                System.out.println("Please, enter a number between 0 and " + (index));
            }
        }
        return Difficulty.values()[choice-1];
    }

    /**
     * Manages a game: the display of the Timer, the message and the Grid.
     */
    public void playGame() {

    }


    /**
     * Displays the grid, in an array of 4x4 on the terminal. The values in the Grid are the "activeFace" of the Dice in the "slots" attribute.
     */
    public void displayGrid(boolean timeOff) {
    }



    public void displayTimer(boolean warning){

    }

}
