package c.mariage;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Die {

    /**
     * Array of the 6 faces of a Die
     */
    private final String[] faces;

    /**
     * The face up top, which will be displayed.
     */
    private String activeFace;

    /**
     * Tells if the Die is set inside a grid slot or not.
     */
    private boolean inSlot;

    /**
     * Constructor. Takes the List given in parameter and sets the attribute "faces" with the values.
     * @param listFaces the list of the Die's faces
     */
    public Die(List<String> listFaces){

        this.faces = new String[6];
        this.inSlot = false;

        int index=0;
        Iterator<String> it = listFaces.iterator();
        while(it.hasNext()){
            this.faces[index] = it.next();
            index++;
        }
    }

    /**
     * Getter for the active face.
     */
    public String getActiveFace() { return this.activeFace; }

    /**
     * Getter for the "faces" attribute.
     * @return an array of the 6 faces of the die
     */
    public String[] getFaces(){ return this.faces; }

    /**
     * Getter for the "inSlot" attribute.
     * @return if the dice is in a slot or not
     */
    public boolean isInSlot() {
        return this.inSlot;
    }

    /**
     * Setter for the "inSlot" attribute. Is called by Grid.shuffleDice() and Grid.resetGrid().
     * @param inSlot is true or false
     */
    public void setInSlot(boolean inSlot) {
        this.inSlot = inSlot;
    }

    /**
     * Setter. Sets randomly the active face.
     * @return The face chosen to be active.
     */
    public String rollDie(){

        Random rand = new Random();
        this.activeFace = this.faces[rand.nextInt(6)];
        return this.getActiveFace();
    }

    /**
     * Returns each face of the Die in a String format. Used for debugging.
     * @return the faces of the dice in a String format
     */
    @Override
    public String toString(){
        String res = "";
        for (String letter: this.faces){
            res+= letter+" ";
        }
        return res;
    }
}
