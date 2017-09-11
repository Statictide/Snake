package framework;

import standard.Snake;

import java.util.Map;

public interface Game {

    /**
     * Moves the snake in the specified direction
     * @param dir
     * @return
     */
    boolean moveSnake(Direction dir);

    /**
     * Returns the snake's head's position
     * @return Position object containing the head's position
     */
    Snake getSnake();

    /**
     * Returns the positions of all points
     * @return List of positions
     */
    Map<Position, WorldItem> getWorldItems();

    /**
     * Returns the length of the snake
     * @return positive integer
     */
    int getScore();

    /**
     * Prints the game world into the terminal
     */
    void print();

}
