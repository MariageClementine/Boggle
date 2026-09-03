package c.mariage;

import org.junit.jupiter.api.BeforeEach;
import c.mariage.Grid;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    private Die die;

    @Test
    public void dieWellFormed(){
        this.die = new Die(Grid.DICE_FACES.getFirst());
        /**
         * To complete
         */
    }

}