package standard;

import framework.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;


/**
 * Handels game commands and game world
 */
public class GameImp implements Game {
    private Snake snake;
    private Map<Position, WorldItem> worldItems;

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
	    worldItems.put(new Position(1, 5), WorldItem.APPLE);
	    worldItems.put(new Position(2, 10), WorldItem.APPLE);
	    worldItems.put(new Position(2, 10), WorldItem.APPLE);
	    worldItems.put(new Position(5, 10), WorldItem.APPLE);
	    worldItems.put(new Position(6, 4), WorldItem.APPLE);
	    worldItems.put(new Position(7, 6), WorldItem.APPLE);
	    worldItems.put(new Position(8, 10), WorldItem.APPLE);
	    worldItems.put(new Position(4, 3), WorldItem.APPLE);
	    worldItems.put(new Position(5, 18), WorldItem.APPLE);
	    worldItems.put(new Position(6, 7), WorldItem.APPLE);
	    worldItems.put(new Position(11, 7), WorldItem.APPLE);
	    worldItems.put(new Position(12, 9), WorldItem.APPLE);
	    worldItems.put(new Position(13, 5), WorldItem.APPLE);
	    worldItems.put(new Position(7, 12), WorldItem.APPLE);
	    worldItems.put(new Position(8, 19), WorldItem.APPLE);
	    worldItems.put(new Position(9, 15), WorldItem.APPLE);
	    worldItems.put(new Position(10, 3), WorldItem.APPLE);
	    worldItems.put(new Position(11, 19), WorldItem.APPLE);
	    worldItems.put(new Position(12, 1), WorldItem.APPLE);
	    worldItems.put(new Position(13, 4), WorldItem.APPLE);
	    worldItems.put(new Position(14, 16), WorldItem.APPLE);
	    worldItems.put(new Position(15, 5), WorldItem.APPLE);
	    worldItems.put(new Position(16, 13), WorldItem.APPLE);
	    worldItems.put(new Position(17, 6), WorldItem.APPLE);
	    worldItems.put(new Position(18, 2), WorldItem.APPLE);
	    worldItems.put(new Position(19, 17), WorldItem.APPLE);
    }

    @Override
    public boolean moveSnake(Direction dir) {
        return snake.move(dir);
    }

    @Override
    public Snake getSnake() {
        return snake;
    }

    @Override
    public Map<Position, WorldItem> getWorldItems() {
        return worldItems;
    }

    @Override
    public int getScore() {
        return snake.getHeadlessBody().size();
    }

    @Override
    public Status getStatus() {
        //Handle hitting wall
        if(!snake.getHead().isValid()) return Status.DEFEAT;

        //If headlessBody contains the head position, the snake has hit itself
        if(snake.getHeadlessBody().contains(snake.getHead())) return Status.DEFEAT;


        return Status.PLAYING;
    }

    /* Redundant
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
                } else if (snake.getHeadlessBody().contains(position)) {
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
    */
}
