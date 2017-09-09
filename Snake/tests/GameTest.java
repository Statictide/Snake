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

    @Test
    public void SnakeCanMoveInAllDirections() {
        //Up
        assertThat( game.moveUp(), is(true));
        assertThat(game.getPosition(), is(new Position(9,10)));

        //Right
        assertThat( game.moveRight(), is(true));
        assertThat(game.getPosition(), is(new Position(9,11)));

        //Down
        assertThat( game.moveDown(), is(true));
        assertThat(game.getPosition(), is(new Position(10,11)));

        //Left and back to the center
        assertThat( game.moveLeft(), is(true));
        assertThat(game.getPosition(), is(new Position(10,10)));
    }
}