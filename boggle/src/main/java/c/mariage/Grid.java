package c.mariage;

import c.mariage.exception.DieNotAddedException;
import java.util.List;
import java.util.Random;

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
    private final Die[][] slots;

    /**
     * The Dice array that will be used by the slots. The size of the list is 16, in the default version of the grid.
     */
    private final Die[] diceArray;

    /**
     * Default constructor, representing the grid by default (4x4 slots). Creates the "slots" Array and the Dice,
     * then fills the "diceArray" attribute.
     */
    public Grid()  {
        // Initializing arrays size
        this.diceArray = new Die[16];
        this.slots = new Die[4][4];

        //Instantiating Dice
        int index = 0;
        Die die;

        //Each of the 16 dice
        for (List<String> list : this.DICE_FACES) {

            //Is created
            die = this.createDie(list);

            //And added to the array
            this.addDieToArray(index, die);
            index++;
        }

    }

    /**
     * Getter for the "slots" attribute.
     * @return the slots of the Grid, which are dice in a 2 dimensioned array
     */
    public Die[][] getSlots(){
        return this.slots;
    }

    /**
     * Setter for the "slots" attribute.
     * @param xSlot the position in the row
     * @param ySlot the position in the column
     * @param die the Die to be inserted
     * @return 0 if the Die was successfully inserted in the slot, 1 if the slot is already taken
     */
    public int setSlot (int xSlot, int ySlot, Die die){

        if (this.slots[xSlot][ySlot]!=null){
            return 1;
        }
        else{
            this.slots[xSlot][ySlot] = die;
            return 0;
        }
    }

    /**
     * Getter for the "diceArray" attribute.
     * @return the array of Dice used for the game
     */
    public Die[] getDiceArray(){
        return this.diceArray;
    }

    /**
     * Instantiates the dice that will be used in the game.
     * The parameter is the List of the Die's faces.
     * @return the Die created
     */
    public Die createDie(List<String> list){
        return new Die(list);
    }

    /**
     * Setter for the "diceArray" attribute. Adds a die in the "diceArray"
     * @param pos the position in the List
     * @param die the die to add to the List
     * @exception DieNotAddedException if an error occurred with the index of the array
     */
    public void addDieToArray(int pos, Die die) throws DieNotAddedException{
        if (this.diceArray[pos]!=null){
            throw new DieNotAddedException("Position already taken in Array of Dice");
        }
        else{
            this.diceArray[pos] = die;
        }
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

        Random ran = new Random();
        int res;

        //Going through each die in the array
        for (Die die : this.getDiceArray()){

            //as long as the dice hasn't been placed
            while(!die.isInSlot()){

                //trying the insertion
                res = this.setSlot(ran.nextInt(4), ran.nextInt(4), die );

                //if successful, stop the while loop
                if (res == 0){
                    die.setInSlot(true);
                }
            }
        }
    }

    /**
     * Sets the "slots" array elements to "null".
     */
    public void resetGrid(){

        //empty the slots
        for(int i=0; i<4; i++){
           for (int j=0; j<4; j++){
               this.slots[i][j] = null;
           }
        }

        // each Die is out of the slots
        for (Die die : this.getDiceArray()){
            die.setInSlot(false);
        }
    }
}
