package c.mariage;

import java.util.List;

public class Die {

    /**
     * Array of the 6 faces of a Die
     */
    private String[] faces;

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
            if(this.faces[i] == null)
                throw new NullPointerException("Error while initializing a die!");

            this.faces[i] = listFaces.get(i);
        }
    }

    /**
     * Getter for the active face.
     */
    public String getActiveFace() { return this.activeFace; }
}
