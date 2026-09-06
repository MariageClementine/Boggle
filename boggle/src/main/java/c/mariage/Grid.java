package c.mariage;

import java.util.List;
import c.mariage.Die;

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
     * The Dice list that will be used by the slots. The size of the list is 16, in the default version of the grid.
     */
    private Die[] dices;

    /**
     * Default contructor, representing the grid by default (4x4 slots). Creates the "slots" Array and the Dice,
     * then fills the "dice" attribute.
     */
    public Grid(){
        // Initializing arrays size
        this.dices = new Die[16];
        this.slots = new Die[4][4];

        //Instantiating Dice
        for (Die d: this.DICE_FACES){
            
        }


        //Instantiating slots

    }

    /**
     *
     * @return
     */
    public Die[][] getSlots(){
        return null;
    }

    /**
     *
     * @param xSlot
     * @param ySlot
     * @param die
     */
    public void setSlot (int xSlot, int ySlot, Die die){

    }

    /**
     *
     * @return
     */
    public Die[] getDiceList(){
        return null;
    }

    /**
     *
     * @param pos
     * @param die
     */
    public void setDices(int pos, Die die){

    }

    /**
     *
     */
    public void displayGrid(){

    }

    /**
     *
     */
    public void shuffleDice(){

    }

    /**
     *
     */
    public void resetGrid(){

    }
}
