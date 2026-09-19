package com.boggle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class TerminalDisplay {

    /**
     * Colours used in the terminal for better visual.
     */
    protected static final String WARNING_COLOUR = "\u001B[38;2;181;9;9m";
    protected static final String RESET_COLOUR = "\u001B[0m";
    protected static final String GRID_COLOUR = "\u001B[48;2;160;160;160m\u001B[30m";
    protected static final String TIMER_OFF_COLOUR = "\u001B[48;2;160;160;160m\u001B[38;2;181;9;9m";

    /**
     * The grid to be displayed.
     */
    private final Grid grid;

    /**
     * The numbers of seconds required for the timer.
     */
    private int seconds;

    /**
     * The timer that will be used in the game.
     */
    private Timer timer;


    /**
     * Constructor.
     */
    public TerminalDisplay(Grid grid){
        this.grid = grid;
        this.timer = new Timer();
    }

    /**
     *
     */
    public void setSeconds(int secs){
        this.seconds = secs;
    }

    /**
     * Displays the Boggle rules to the user, using ANSI formatting.
     */
    public void displayRules(){
        InputStream inStr = getClass().getClassLoader().getResourceAsStream("Rules.txt");

        if (inStr == null){
            throw new IllegalArgumentException("Rules file not found.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStr, StandardCharsets.UTF_8))) {
            String res =  reader.lines().collect(Collectors.joining("\n"));
            System.out.println(res.replace("\\u001B","\u001B"));

        } catch( Exception e){
            System.out.println("Error while reading the rules file: "+e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Displays the grid, in an array of 4x4 on the terminal. The values in the Grid are the "activeFace" of the Dice in the "slots" attribute.
     */
    public void displayGrid(boolean timeOff) {

        String col = (timeOff) ? TerminalDisplay.TIMER_OFF_COLOUR : TerminalDisplay.GRID_COLOUR;
        System.out.println(this.grid.toString(col));
    }

    /**
     * Displays the timer. Formatted in red if there are 10 seconds left.
     * @param secondsLeft the seconds that have to be formatted to be displayed
     */
    public void displayTimer(int secondsLeft){
        int min = secondsLeft / 60;
        int secs = secondsLeft % 60;
        String col = "";
        String strMin = "";
        String strSec = "";

        if(min<10){
            strMin = "0"+ String.valueOf(min);
        }
        if(secs < 10){
            strSec = "0" + String.valueOf(secs);
        }

        if(min == 0 && secs <= 10){
            col = TerminalDisplay.TIMER_OFF_COLOUR;
        }
        else {
            col = TerminalDisplay.GRID_COLOUR;
        }
        System.out.println(col + strMin + " : " + strSec + TerminalDisplay.RESET_COLOUR);
    }

    /**
     *
     * @param secondsLeft
     */
    public void displayMessage(int secondsLeft){
        if(secondsLeft>10){
            System.out.println(TerminalDisplay.GRID_COLOUR+ " Let's Go!"+TerminalDisplay.RESET_COLOUR);
        }
        else if (secondsLeft <= 10 && secondsLeft > 0){
            System.out.println(TerminalDisplay.WARNING_COLOUR+ "10 seconds left!"+TerminalDisplay.RESET_COLOUR);
        }
        else{
            System.out.println(TerminalDisplay.TIMER_OFF_COLOUR + "Time's Up!"+TerminalDisplay.RESET_COLOUR);
        }
    }

    /**
     * Displays a game session: the display of the Timer, the message and the Grid.
     */
    public void displayGame() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                /* *******
                \x1B[NF Goes back to the beginning of the N-th previous line
                 ********** */

                // display
                displayMessage(seconds);
                // if time is up
                if(seconds == 0){
                    displayGrid(true);
                    timer.cancel();
                }
                else {
                    displayGrid(false);
                }
                displayTimer(seconds);

                //decrease secs left
                seconds --;

            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
