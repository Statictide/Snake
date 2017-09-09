package standard;

import framework.*;

import java.util.List;



public class GameImp implements Game{
    Snake snake;

    public GameImp(Position snakeHeadPosition) {
        this.snake = new Snake(snakeHeadPosition, Direction.UP);
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
        return null;
    }

    @Override
    public void print() {

    }
}
