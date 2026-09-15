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
        this.grid = null;
        this.chosenDifficulty = null;
    }

    /**
     * Displays a list of the different actions possible (Action Menu enum).
     * @return -1 if the user wants to exit the program, an int otherwise
     */
    public int displayMenu(){
        return 0;
    }

    /**
     * Asks the user for the difficulty of the game. A higher difficulty means less time on the timer. Registers the answer in the "chosenDifficulty" attribute.
     * @return -1 if the user wants to return to the menu, 0 if they chose a difficulty.
     */
    public int chooseDifficulty(){

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
                System.out.println("Please, enter a number between 1 and " + (index-1));
            }
            if (choice == 0){
                return -1;
            }
        }
        this.chosenDifficulty = Difficulty.values()[choice-1];
        return 0;

    }

    /**
     * Displays the Boggle rules to the user. Waits for any input to go back to the menu.
     */
    public void displayRules(){

    }

    /**
     * Manages a game: the display of the Timer, the message and the Grid.
     */
    public void playGame() {
        this.grid = new Grid();
    }


    /**
     * Displays the grid, in an array of 4x4 on the terminal. The values in the Grid are the "activeFace" of the Dice in the "slots" attribute.
     */
    public void displayGrid(boolean timeOff) {
    }



    public void displayTimer(boolean warning){

    }

}
