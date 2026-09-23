package com.boggle;


import com.boggle.util.ActionMenu;
import com.boggle.util.Difficulty;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n******************");
        System.out.println("Welcome to Boggle!");
        System.out.println("******************\n");
        System.out.println("Before playing, please make sure that your terminal is configured with utf-8 encoding.\nThis is to avoid any display error.\n");

        GameManager gm = new GameManager();
        TerminalDisplay td = new TerminalDisplay(gm.getGrid());

        boolean playingGame = false;

        while(!playingGame) {
            ActionMenu menuChoice = gm.displayMenu(false);
            switch (menuChoice) {
                case EXIT:
                    System.out.println("See you later!");
                    System.exit(0);
                    break;
                case DISPLAY_RULES:
                    td.displayRules();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case PLAY_GAME:
                    gm.playGame();
                    playingGame = true;
            }
        }

    }

}
