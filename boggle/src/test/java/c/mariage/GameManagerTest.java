package c.mariage;

import c.mariage.util.Difficulty;
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
    public void chooseDifficultyTest(){
        Difficulty diff = this.gm.chooseDifficulty();
        System.out.println(diff.getMinutes());
    }

}