package com.boggle;


import com.boggle.util.ActionMenu;
import com.boggle.util.Difficulty;
import com.boggle.util.Input;
import java.io.IOException;

public class GameManager {

    /**
     * The grid for the game. Contains an instantiation of the Grid object once startGame() has been called. Contains null otherwise.
     */
    private final Grid grid;

    /**
     * The chosen difficulty, affecting the time of a match.
     */
    private Difficulty chosenDifficulty;

    /**
     *
     */
    private TerminalDisplay td;

    /**
     * Constructor.
     */
    public GameManager(){
        this.grid = new Grid();
        this.chosenDifficulty = null;
    }

    /**
     * Getter for the "grid " attribute.
     * @return the created Grid
     */
    public Grid getGrid(){
        return this.grid;
    }

    /**
     * Displays a list of the different actions possible (Action Menu enum).
     * @return -1 if the user wants to exit the program, an int otherwise
     */
    public ActionMenu displayMenu(){
        int choice = -1;
        while ((choice < 0) || (choice > ActionMenu.values().length)) {
            System.out.println("Please chose an option in the menu (enter a number): ");
            int index = 0;

            for (ActionMenu act : ActionMenu.values()) {
                System.out.println("  " + (index++) + " - " + act.name());
            }
            System.out.println("*_____ What is your choice ? _____*");

            try {
                choice = Input.readInt();
            } catch (IOException e) {
                System.out.println("Please, enter a number between 1 and " + (index-1));
            }
        }
        return ActionMenu.values()[choice];
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
            } catch (IOException e) {
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
     *
     */
    public void startGame() {
        int diff = this.chooseDifficulty();

        //in case we have to return to the menu
        if (diff == -1) {
            this.displayMenu();
        } else {

            //Starting the display
            this.td = new TerminalDisplay(this.grid,this.chosenDifficulty.getSeconds());

            //using the TerminalDisplay

            //setting the grid for a session
            this.getGrid().shuffleDice();
        }
    }
}
