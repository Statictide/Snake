package standard;

import framework.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Handels game commands and game world
 */
public class GameImp implements Game {
    Snake snake;
    List<Position> points;

    public GameImp(Position snakeHeadPosition) {
        this.snake = new Snake(snakeHeadPosition, Direction.UP);
        points = new ArrayList<>();

        initGameWorld();
    }

    /**
     * Adds initial points to game world
     */
    private void initGameWorld(){
        points.add(new Position(8, 10));
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
    public List<Position> getPoints() {
        return points;
    }

    @Override
    public void print() {

    }
}
