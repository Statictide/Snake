import framework.*;
import org.junit.Before;
import org.junit.Test;
import standard.GameImp;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.nullValue;
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

    @Test
    public void ShouldBePointAt8_10() {
        assertThat( game.getWorldItems().get(new Position(8,10)), is(WorldItem.APPLE));
    }

    @Test
    public void SnakeShouldGrowUponEatingPoint() {
        game.moveUp(); //9,10
        game.moveUp(); //8,10

        assertThat(game.getScore(), is(2));
    }

    @Test
    public void AppleShouldBeRemovedAfterEating() {
        game.moveUp(); //9,10
        game.moveUp(); //8,10 apple

        assertThat(game.getWorldItems().get(new Position(8,10)), is(nullValue()));
    }

    @Test
    public void SnakeShouldNotReverseDirection() {
        game.moveUp();
        assertThat( game.moveDown(), is(false));
        assertThat(game.getPosition(), is(new Position(9,10)));

        game.moveLeft();
        assertThat( game.moveRight(), is(false));
        assertThat(game.getPosition(), is(new Position(9,9)));

    }
}