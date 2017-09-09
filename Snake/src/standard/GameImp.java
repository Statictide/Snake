package standard;

import framework.*;

import java.util.List;



public class GameImp implements Game{
    Position snakeHeadPosition;

    public GameImp(Position snakeHeadPosition) {
        this.snakeHeadPosition = snakeHeadPosition;
    }

    @Override
    public boolean moveUp() {
        snakeHeadPosition = snakeHeadPosition.getPosition(Direction.UP);
        return true;
    }

    @Override
    public boolean moveDown() {
        snakeHeadPosition = snakeHeadPosition.getPosition(Direction.DOWN);
        return true;
    }

    @Override
    public boolean moveLeft() {
        snakeHeadPosition = snakeHeadPosition.getPosition(Direction.LEFT);
        return true;
    }

    @Override
    public boolean moveRight() {
        snakeHeadPosition = snakeHeadPosition.getPosition(Direction.RIGHT);
        return true;
    }

    @Override
    public Position getPosition() {
        return snakeHeadPosition;
    }

    @Override
    public List<Position> getPoints() {
        return null;
    }

    @Override
    public void print() {

    }
}
