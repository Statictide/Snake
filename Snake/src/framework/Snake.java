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
    Game game;


    /**
     * Create new snake of length 1
     * @param head      Initial position of head
     * @param direction Initial direction snake is facing
     */
    public Snake(Position head, Direction direction, Game game) {
        this.head = head;
        this.tail = head;
        this.body = new ArrayList<>();
        this.body.add(head);

        this.direction = direction;
        this.game = game;
    }

    public Position getHead() {
        return head;
    }

    public List<Position> getBody() {
        return body;
    }

    /**
     * Moves the snake is the specified direction, and grows in length.
     * @param dir Direction of movement
     */
    public boolean move(Direction dir) {
        //Reversing direction is illegal
        if(direction.getReverse() == dir) return false;

        //Move snake forward
        direction = dir;
        head = head.getPosition(dir);
        body.add(head);

        if(game.getWorldItems().get(head) == null){
            //Remove tail from body and update tail
            body.remove(tail);
            tail = body.get(body.size() - 1);
        }

        return true;
    }
}
