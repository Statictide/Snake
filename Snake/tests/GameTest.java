import framework.*;
import org.junit.Before;
import org.junit.Test;
import standard.GameImp;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

/**
 * Created by markn on 09-09-2017.
 */
public class GameTest {
    Game game;

    @Before
    public void setUp() throws Exception {
        game = new GameImp(new Position(10,10));
    }

    @Test
    public void JunitTest() {
        assertEquals(true, true);
    }

    @Test
    public void SnakeIsAt10_10() {
        assertThat(game.getPosition(), is(new Position(10,10)));
    }
}