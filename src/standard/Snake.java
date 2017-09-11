package standard;

import framework.Direction;
import framework.Game;
import framework.Position;
import framework.WorldItem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Handels position and movement of head, tail and body of snake
 */
public class Snake {
    Position head;
    Position tail;
    Queue<Position> body;
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
        this.body = new LinkedList<>();
        this.body.add(head);

        this.direction = direction;
        this.game = game;
    }

    public Position getHead() {
        return head;
    }

    public Queue<Position> getBody() {
        return body;
    }

    /**
     * Moves the snake is the specified direction, and grows in length. Cannot reverse direction.
     * @param dir Direction of movement
     * @return false if reversing direction, true otherwise.
     */
    public boolean move(Direction dir) {
        //Reversing direction is illegal
        if (direction.getReverse() == dir) return false;

        //Move snake forward
        direction = dir;
        head = head.getPosition(dir);
        body.add(head);

        if (game.getWorldItems().get(head) == WorldItem.APPLE) {
            //Remove apple from world
            game.getWorldItems().remove(head);
        } else if (game.getWorldItems().get(head) == null) {
            //Remove tail from body and update tail
            body.remove(tail);
            tail = body.element();
        }

        return true;
    }
}
