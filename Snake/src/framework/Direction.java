package framework;

/**
 * Created by markn on 09-09-2017.
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    //Holds reverse direction for each enum obj
    private Direction reverse;

    //Sets the reverse value
    static {
        UP.reverse = DOWN;
        DOWN.reverse = UP;
        LEFT.reverse = RIGHT;
        RIGHT.reverse = LEFT;
    }

    /**
     * Returns the opposite direction
     * @return Opposite direction
     */
    public Direction getReverse(){
        return reverse;
    }
}


