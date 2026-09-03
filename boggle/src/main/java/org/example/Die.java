package org.example;

import java.util.List;

public class Die {

    private String[] faces;

    /**
     * Constructor. Takes the List given in parameter and sets the attribute "faces" with the values.
     * @param listFaces the list of the Die's faces
     */
    public Die(List<String> listFaces){

        for(int i= 0; i<5;i++){
            if(this.faces[i] == null)
                throw new NullPointerException("Error while initializing a die!");

            this.faces[i] = listFaces.get(i);
        }
    }
}
