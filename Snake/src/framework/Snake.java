package framework;


import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    Position head;
    Position tail;
    List<Position> body;

    Direction direction;

    /**
     * Create new snake of length 1
     * @param head Initial position of head
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

    public void move(Direction dir){
        head = head.getPosition(dir);
    }
}
