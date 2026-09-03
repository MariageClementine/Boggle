package c.mariage;

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
     * Constructor. Takes the List given in parameter and sets the attribute "faces" with the values.
     * @param listFaces the list of the Die's faces
     */
    public Die(List<String> listFaces){

        this.faces = new String[6];

        for(int i= 0; i<this.faces.length;i++){
            this.faces[i] = listFaces.get(i);
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
     * Setter. Sets randomly the active face.
     * @return The face chosen to be active.
     */
    public String rollDie(){

        Random rand = new Random();
        this.activeFace = this.faces[rand.nextInt(6)];
        return this.getActiveFace();
    }
}
