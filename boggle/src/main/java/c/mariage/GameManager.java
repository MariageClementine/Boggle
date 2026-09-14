package c.mariage;


public class GameManager {

    /**
     * The grid for the game. Contains an instantiation of the Grid object once startGame() has been called. Contains null otherwise.
     */
    private Grid grid;

    /**
     * The chosen difficulty, affecting the time of a match.
     */
    private int ChosenDifficulty;

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
    }

    /**
     * Asks the user for the difficulty of the game. A higher difficulty means less time on the timer.
     * @return the number corresponding to the chosen difficulty
     */
    public int chooseDifficulty(){
        return 0;
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
