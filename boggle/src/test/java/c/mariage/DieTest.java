package c.mariage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    private Grid grid;
    private Die die;

    @BeforeEach
    public void before(){
        this.grid = new Grid();
        this.die = new Die(this.grid.DICE_FACES.getFirst());
    }

    @Test
    public void dieIsWellFormed(){

        //testing 1st face of 1st die
        assertEquals(this.grid.DICE_FACES.getFirst().getFirst(), this.die.getFaces()[0]);
    }

    @Test
    public void randomActiveFaceTest(){

        System.out.println("Active face before roll: "+this.die.getActiveFace());
        assertInstanceOf(String.class, this.die.rollDie());
        System.out.println("Active face after roll:"+ this.die.getActiveFace());
        assertTrue(this.grid.DICE_FACES.getFirst().contains(this.die.getActiveFace()));
    }


}