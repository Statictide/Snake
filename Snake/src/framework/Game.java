package framework;

import javafx.geometry.Pos;

import java.util.List;

public interface Game {

    /**
     * Moves the snake's head one step if possible
     * @return true if position is not occupied
     */
    boolean moveUp();

    /**
     * Moves the snake's head one step if possible
     * @return true if position is not occupied
     */
    boolean moveDown();

    /**
     * Moves the snake's head one step up if possible
     * @return true if position is not occupied
     */
    boolean moveLeft();

    /**
     * Moves the snake's head one step up if possible
     * @return true if position is not occupied
     */
    boolean moveRight();

    /**
     * Returns the snake's head's position
     * @return Position object containing the head's position
     */
    Position getPosition();

    /**
     * Returns the positions of all points
     * @return List of positions
     */
    List<Position> getPoints();

    /**
     * Prints the game world into the terminal
     */
    void print();

}
