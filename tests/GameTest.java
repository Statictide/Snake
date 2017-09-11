import framework.*;
import org.junit.Before;
import org.junit.Test;
import standard.GameImp;


import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;


public class GameTest {
    Game game;

    @Before
    public void setUp() throws Exception {
        game = new GameImp(new Position(10, 10));
    }

    @Test
    public void JunitTest() {
        assertEquals(true, true);
    }

    @Test
    public void SnakeIsAt10_10() {
        assertThat(game.getPosition(), is(new Position(10, 10)));
    }

    @Test
    public void SnakeCanMoveInAllDirections() {
        //Up
        assertThat(game.moveSnake(Direction.UP), is(true));
        assertThat(game.getPosition(), is(new Position(9, 10)));

        //Right
        assertThat(game.moveSnake(Direction.RIGHT), is(true));
        assertThat(game.getPosition(), is(new Position(9, 11)));

        //Down
        assertThat(game.moveSnake(Direction.DOWN), is(true));
        assertThat(game.getPosition(), is(new Position(10, 11)));

        //Left and back to the center
        assertThat(game.moveSnake(Direction.LEFT), is(true));
        assertThat(game.getPosition(), is(new Position(10, 10)));
    }

    @Test
    public void ShouldBePointAt8_10() {
        assertThat(game.getWorldItems().get(new Position(8, 10)), is(WorldItem.APPLE));
    }

    @Test
    public void SnakeShouldGrowUponEatingPoint() {
        game.moveSnake(Direction.UP); //9,10
        game.moveSnake(Direction.UP); //8,10

        assertThat(game.getScore(), is(2));
    }

    @Test
    public void AppleShouldBeRemovedAfterEating() {
        game.moveSnake(Direction.UP); //9,10
        game.moveSnake(Direction.UP); //8,10 apple

        assertThat(game.getWorldItems().get(new Position(8, 10)), is(nullValue()));
    }

    @Test
    public void SnakeShouldNotReverseDirection() {
        game.moveSnake(Direction.UP);
        assertThat(game.moveSnake(Direction.DOWN), is(false));
        assertThat(game.getPosition(), is(new Position(9, 10)));

        game.moveSnake(Direction.LEFT);

        assertThat(game.moveSnake(Direction.RIGHT), is(false));
        assertThat(game.getPosition(), is(new Position(9, 9)));

    }
}