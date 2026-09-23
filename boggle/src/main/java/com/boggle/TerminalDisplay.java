package com.boggle;

import com.boggle.util.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
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
     * Constructor. Retrieves the grid given in parameter and instantiates a new Timer.
     */
    public TerminalDisplay(Grid grid){
        this.grid = grid;
        this.timer = new Timer();
    }

    /**
     * Setter for the seconds left on the timer
     * @param secs the seconds left on the timer
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
     * Formats the grid, in an array of 4x4 and with specific colours. The values in the Grid are the "activeFace" of the Dice in the "slots" attribute.
     * @param timeOff true id the timer has ended, false if not.
     * @return A String representing the grid.
     */
    public String displayGrid(boolean timeOff) {

        String col = (timeOff) ? TerminalDisplay.TIMER_OFF_COLOUR : TerminalDisplay.GRID_COLOUR;
        return this.grid.toString(col);
    }

    /**
     * Displays the timer. Formatted in red if there are 10 seconds left.
     * @param secondsLeft the seconds that have to be formatted to be displayed
     * @return the timer in a "mm:ss" String format.
     */
    public String displayTimer(int secondsLeft){
        int min = secondsLeft / 60;
        int secs = secondsLeft % 60;
        String col = "";
        String strMin = String.valueOf(min);
        String strSec = String.valueOf(secs);

        if(min<10){
            strMin = "0"+ strMin;
        }
        if(secs < 10){
            strSec = "0" + strSec ;
        }

        if(min == 0 && secs <= 10){
            col = TerminalDisplay.TIMER_OFF_COLOUR;
        }
        else {
            col = TerminalDisplay.GRID_COLOUR;
        }
        return (col + strMin + " : " + strSec + TerminalDisplay.RESET_COLOUR);
    }

    /**
     * Displays a message, which varies depending on the amount of seconds left
     * @param secondsLeft the seconds left on the timer
     * @return the message, in a String format
     */
    public String displayMessage(int secondsLeft){
        if(secondsLeft>10){
            return (TerminalDisplay.GRID_COLOUR+ " Let's Go!       "+TerminalDisplay.RESET_COLOUR);
        }
        else if (secondsLeft <= 10 && secondsLeft > 0){
            return (TerminalDisplay.WARNING_COLOUR+ secondsLeft+ " seconds left!"+TerminalDisplay.RESET_COLOUR);
        }
        else{
            return (TerminalDisplay.TIMER_OFF_COLOUR + "Time's Up!       "+TerminalDisplay.RESET_COLOUR);
        }
    }

    /**
     * Displays a game session: the display of the Timer, the message and the Grid.
     */
    public void displayGame() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // building the display
                StringBuilder strBuild = new StringBuilder();
                strBuild.append(displayMessage(seconds)).append("\n");
                // if time is up
                if (seconds == 0) {
                    strBuild.append(displayGrid(true));
                    timer.cancel();
                } else {
                    strBuild.append(displayGrid(false));
                }

                strBuild.append(displayTimer(seconds)).append("\n ");

                if (seconds > 0) {
                    strBuild.append("\u001B[12F");
                }
                System.out.println(strBuild.toString());

                //decrease secs left
                seconds--;

            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

}
