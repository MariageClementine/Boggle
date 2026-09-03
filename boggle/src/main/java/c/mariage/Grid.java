package c.mariage;

import java.util.List;

public class Grid {
    /**
     *  Lists all the faces (interior List) for each dice (exterior List).
     *  The same dices are always used, just randomly positioned, thus the choice of a constant.
     */
    public static final List<List<String>> DICE_FACES = List.of(
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
}
