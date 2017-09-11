package framework;

import standard.Snake;

import java.util.Map;

public interface Game {

    /**
     * Moves the snake in the specified direction
     *
     * @param dir
     * @return
     */
    boolean moveSnake(Direction dir);

    /**
     * Returns the snake's head's position
     *
     * @return Position object containing the head's position
     */
    Snake getSnake();

    /**
     * Returns the positions of all points
     *
     * @return List of positions
     */
    Map<Position, WorldItem> getWorldItems();


    /**
     * Returns the amount of apples eaten
     * @return positive integer
     */
    int getScore();

    public Status getStatus();
    public enum Status {PLAYING, DEFEAT, WICTORY}


    /**
     * Prints the game world into the terminal
     */
    //void print();

}
