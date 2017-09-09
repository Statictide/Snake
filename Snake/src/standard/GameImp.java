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
        return false;
    }

    @Override
    public boolean moveDown() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public boolean moveRight() {
        return false;
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
