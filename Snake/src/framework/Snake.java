package framework;


import java.util.ArrayList;
import java.util.List;

/**
 * Handels position and movement of head, tail and body of snake
 */
public class Snake {
    Position head;
    Position tail;
    List<Position> body;

    Direction direction;

    /**
     * Create new snake of length 1
     *
     * @param head      Initial position of head
     * @param direction Initial direction snake is facing
     */
    public Snake(Position head, Direction direction) {
        this.head = head;
        this.tail = head;
        this.body = new ArrayList<>();
        this.body.add(head);

        this.direction = direction;
    }

    public Position getHead() {
        return head;
    }

    public List<Position> getBody() {
        return body;
    }

    public void move(Direction dir) {
        head = head.getPosition(dir);
    }
}
