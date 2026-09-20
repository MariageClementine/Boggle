package com.boggle;

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

}