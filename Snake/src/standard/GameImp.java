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
        worldItems.put(new Position(8, 12), WorldItem.APPLE);
        worldItems.put(new Position(8, 14), WorldItem.APPLE);
    }

    @Override
    public boolean moveUp() {
        return snake.move(Direction.UP);
    }

    @Override
    public boolean moveDown() {
        return snake.move(Direction.DOWN);
    }

    @Override
    public boolean moveLeft() {
        return snake.move(Direction.LEFT);
    }

    @Override
    public boolean moveRight() {
        return snake.move(Direction.RIGHT);
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
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < GameConstants.WORLD_SIZE + 2; i++) {
            result.append("W ");
        }
        result.append('\n');

        for (int row = 0; row < GameConstants.WORLD_SIZE; row++) {
            result.append("W ");
            for (int col = 0; col < GameConstants.WORLD_SIZE; col++) {
                Position position = new Position(row, col);

                if(snake.getHead().equals(position)){
                    result.append("H ");
                } else if (snake.getBody().contains(position)) {
                    result.append("B ");
                } else if (worldItems.get(position) == null) {
                    result.append("  ");
                } else if (worldItems.get(position) == WorldItem.APPLE) {
                    result.append("A ");
                }
            }
            result.append("W \n");
        }


        for (int i = 0; i < GameConstants.WORLD_SIZE + 2; i++) {
            result.append("W ");
        }
        result.append('\n');

        System.out.println(result.toString());
    }
}
