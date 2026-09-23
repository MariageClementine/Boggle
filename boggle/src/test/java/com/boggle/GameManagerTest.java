package com.boggle;

import com.boggle.util.ActionMenu;
import com.boggle.util.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    private GameManager gm;

    @BeforeEach
    public void before() {
        this.gm = new GameManager();
    }

    @Test
    public void correctlyCreatedTest(){
        assertNotNull(this.gm.getGrid());

    }

    @Test
    public void difficultyCorrectlySavedTest(){
        int res = this.gm.chooseDifficulty(true);
        assertEquals(0, res);
        assertSame(Difficulty.NORMAL, this.gm.getChosenDifficulty());
        assertEquals(180, this.gm.getChosenDifficulty().getSeconds());
    }

    @Test
    public void actionCorrectlySelected(){
        ActionMenu action = this.gm.displayMenu(true);
        assertSame(ActionMenu.PLAY_GAME.toString(), action.toString());
    }
}