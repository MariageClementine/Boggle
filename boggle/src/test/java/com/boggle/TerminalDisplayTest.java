package com.boggle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalDisplayTest {

    private TerminalDisplay td;
    private GameManager gm;

    @BeforeEach
    public void before() {
        this.gm = new GameManager();
        this.gm.getGrid().shuffleDice();
        this.td = new TerminalDisplay(this.gm.getGrid());
    }

    @Test
    public void displayGridTest(){
        assertInstanceOf(String.class, this.td.displayGrid(true));
        assertInstanceOf(String.class, this.td.displayGrid(false));
    }

    @Test
    public void displayTimerTest(){
        assertInstanceOf(String.class, this.td.displayTimer(50));
        assertEquals(TerminalDisplay.GRID_COLOUR+"03 : 00"+TerminalDisplay.RESET_COLOUR, this.td.displayTimer(180));
        assertEquals(TerminalDisplay.GRID_COLOUR+"01 : 40"+TerminalDisplay.RESET_COLOUR, this.td.displayTimer(100));
        assertEquals(TerminalDisplay.TIMER_OFF_COLOUR+"00 : 10"+TerminalDisplay.RESET_COLOUR, this.td.displayTimer(10));
        assertEquals(TerminalDisplay.TIMER_OFF_COLOUR+"00 : 00"+TerminalDisplay.RESET_COLOUR, this.td.displayTimer(0));

    }

    @Test
    public void displayMessageTest(){
        assertInstanceOf(String.class, this.td.displayMessage(50));
    }
}