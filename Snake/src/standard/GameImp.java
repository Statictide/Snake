package standard;

import framework.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Handels game commands and game world
 */
public class GameImp implements Game {
    Snake snake;
    Map<Position, WorldItem> worldItems;

    public GameImp(Position snakeHeadPosition) {
        worldItems = new HashMap<>();
        this.snake = new Snake(snakeHeadPosition, Direction.UP, this);

        initGameWorld();
    }

    /**
     * Adds initial worldItems to game world
     */
    private void initGameWorld() {
        //Add initial worldItems
        worldItems.put(new Position(8, 10), WorldItem.APPLE);
    }

    @Override
    public boolean moveUp() {
        snake.move(Direction.UP);
        return true;
    }

    @Override
    public boolean moveDown() {
        snake.move(Direction.DOWN);
        return true;
    }

    @Override
    public boolean moveLeft() {
        snake.move(Direction.LEFT);
        return true;
    }

    @Override
    public boolean moveRight() {
        snake.move(Direction.RIGHT);
        return true;
    }

    @Override
    public Position getPosition() {
        return snake.getHead();
    }

    @Override
    public Map<Position, WorldItem> getWorldItems() {
        return worldItems;
    }

    @Override
    public int getScore() {
        return snake.getBody().size();
    }

    @Override
    public void print() {

    }
}
