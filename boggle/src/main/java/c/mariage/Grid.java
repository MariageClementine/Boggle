package c.mariage;

import java.util.Iterator;
import java.util.List;

public class Grid {
    /**
     *  Lists all the faces (interior List) for each dice (exterior List).
     *  The same dices are always used, just randomly positioned, thus the choice of a constant.
     */
    public final List<List<String>> DICE_FACES = List.of(
            List.of("E","V","G","T","I","N"),
            List.of("D","E","C","A","M","P"),
            List.of("I","E","L","R","U","W"),
            List.of("E","H","I","F","S","E"),
            List.of("R","E","C","A","L","S"),
            List.of("E","N","T","D","O","S"),
            List.of("O","F","X","R","I","A"),
            List.of("N","A","V","E","D","Z"),
            List.of("E","I","O","A","T","A"),
            List.of("G","L","E","N","Y","U"),
            List.of("B","M","A","Q","J","O"),
            List.of("T","L","I","B","R","A"),
            List.of("S","P","U","L","T","E"),
            List.of("A","I","M","S","O","R"),
            List.of("E","N","H","R","I","S"),
            List.of("E","T","U","K","N","O")
    );

    /**
     * Slots contained in the grid. They are ordered as an array of 4x4, in the default version of the grid.
     */
    private Die[][] slots;

    /**
     * The Dice array that will be used by the slots. The size of the list is 16, in the default version of the grid.
     */
    private Die[] diceArray;

    /**
     * Default constructor, representing the grid by default (4x4 slots). Creates the "slots" Array and the Dice,
     * then fills the "diceArray" attribute.
     */
    public Grid(){
        // Initializing arrays size
        this.diceArray = new Die[16];
        this.slots = new Die[4][4];

        //Instantiating Dice
        Iterator<List<String>> it = this.DICE_FACES.iterator();
        int index = 0;
        for (List l: this.DICE_FACES){

        }


        //Instantiating slots

    }

    /**
     * Getter for the "slots" attribute.
     * @return the slots of the Grid, which are dice in a 2 dimensioned array
     */
    public Die[][] getSlots(){
        return null;
    }

    /**
     * Setter for the "slots" attribute.
     * @param xSlot the position in the row
     * @param ySlot the position in the column
     * @param die the Die to be inserted
     */
    public void setSlot (int xSlot, int ySlot, Die die){

    }

    /**
     * Getter for the "diceArray" attribute.
     * @return the list of Dice used for the game
     */
    public Die[] getDiceArray(){
        return null;
    }

    /**
     * Instanciates the dice that will be used in the game.
     * @return the Die created
     */
    public Die createDie(List<String> list){
        return null;
    }

    /**
     * Setter for the "diceArray" attribute. Adds a die in the "diceArray"
     * @param pos the position in the List
     * @param die the die to add to the List
     */
    public void addDieToArray(int pos, Die die){

    }

    /**
     * Displays the grid, in an array of 4x4 on the terminal. The values in the Grid are the "activeFace" of the Dice in the "slots" attribute.
     */
    public void displayGrid(){

    }

    /**
     * Takes the Dice in the "diceArray" and sets them randomly in the "slots" attribute.
     */
    public void shuffleDice(){

    }

    /**
     * Sets the "slots" array elements to "null".
     */
    public void resetGrid(){

    }
}
