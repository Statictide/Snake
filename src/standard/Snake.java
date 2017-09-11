package standard;

import framework.Direction;
import framework.Game;
import framework.Position;
import framework.WorldItem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Handels position and movement of head, tail and headlessBody of snake
 */
public class Snake {
    private Position head;
    private Position tail;
    private Queue<Position> headlessBody;
    private Direction direction;
    private Game game;


    /**
     * Create new snake of length 1
     * @param head      Initial position of head
     * @param direction Initial direction snake is facing
     */
    public Snake(Position head, Direction direction, Game game) {
        this.head = head;
        this.tail = head;
        this.headlessBody = new LinkedList<>();

        this.direction = direction;
        this.game = game;
    }

    public Position getHead() {
        return head;
    }
    public Position getTail() {
        return tail;
    }
    public Queue<Position> getHeadlessBody() {
        return headlessBody;
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
        headlessBody.add(head);
        head = head.getPosition(dir);

        if (game.getWorldItems().get(head) == WorldItem.APPLE) {
            //Remove apple from world when eaten
            game.getWorldItems().remove(head);
        } else if (game.getWorldItems().get(head) == null) {
            //Remove tail from headlessBody
            headlessBody.remove();
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Position p : headlessBody) {
            result.append(p.toString());
            result.append(", ");
        }
        //Remove trailing ", "
        result.reverse();
        result.reverse();

        return result.toString();
    }
}
