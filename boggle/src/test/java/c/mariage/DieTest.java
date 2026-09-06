package c.mariage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    public final List<String> DIE_FACES = List.of("E","V","G","T","I","N");
    private Die die;

    @BeforeEach
    public void before(){
        this.die = new Die(DIE_FACES);
    }

    @Test
    public void dieIsWellFormed(){

        //testing 1st face of 1st die
        assertEquals(this.DIE_FACES.getFirst(), this.die.getFaces()[0]);
    }

    @Test
    public void randomActiveFaceTest(){

        System.out.println("Active face before roll: "+this.die.getActiveFace());
        assertInstanceOf(String.class, this.die.rollDie());
        System.out.println("Active face after roll:"+ this.die.getActiveFace());
        assertTrue(this.DIE_FACES.contains(this.die.getActiveFace()));
    }

    @Test
    public void toStringTest(){
        System.out.println("toString Test: "+this.die.toString());
    }
}