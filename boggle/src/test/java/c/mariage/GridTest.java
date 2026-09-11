package c.mariage;

import c.mariage.exception.DieNotAddedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private Grid grid;
    private Die firstDie;
    private Die lastDie;

    @BeforeEach
    public void before(){
        this.grid = new Grid();
        this.firstDie = new Die(this.grid.DICE_FACES.getFirst());
        this.lastDie = new Die(this.grid.DICE_FACES.getLast());
    }

    @Test
    public void attributesSizeOkTest(){
        assertEquals(16, this.grid.getDiceArray().length);
        assertEquals(4,this.grid.getSlots().length);
        assertEquals(4,this.grid.getSlots()[3].length);
    }

    @Test
    public void createDieTest(){
        Die dieTest = this.grid.createDie(this.grid.DICE_FACES.getFirst());
        assertEquals(this.firstDie.toString(), dieTest.toString());
    }
    @Test
    public void diceAreCreatedCorrectly(){
        //first die created
        assertEquals (this.firstDie.toString(), this.grid.getDiceArray()[0].toString());
        //last die created
        assertEquals(this.lastDie.toString(),this.grid.getDiceArray()[15].toString());
    }

    @Test
    public void slotsEmptyOnCreation(){
        assertNull(this.grid.getSlots()[0][0]);
        assertNull(this.grid.getSlots()[3][3]);
    }

    @Test
    public void exceptionDieNotAddedTest(){
        assertThrows(DieNotAddedException.class,()->this.grid.addDieToArray(0,this.firstDie));
    }

    @Test
    public void setSlotTest(){
        //placing in empty slot
        assertEquals(0,this.grid.setSlot(0,0,this.firstDie));
        //die really inserted
        assertEquals(this.firstDie.toString(), this.grid.getSlots()[0][0].toString());
        //trying a filled slot
        assertEquals(1,this.grid.setSlot(0,0,this.firstDie));
    }

    @Test
    public void resetGridTest(){
        //populate
        this.grid.setSlot(1,2,this.firstDie);
        this.grid.setSlot(3,0,this.lastDie);

        //reset
        this.grid.resetGrid();

        //test
        assertNull(this.grid.getSlots()[1][2]);
        assertNull(this.grid.getSlots()[3][0]);
    }

    /*  Since shuffleDice uses Random a lot, the test will be a display of the grid. It will test shuffleDice and displayGrid both at the same time */
    @Test
    public void shuffleAndDisplayTest(){
        this.grid.shuffleDice();
        System.out.println(this.grid.toString());
        //make sure the dices are randomized
        System.out.println(this.grid.getSlots()[0][0].toString());
    }
}