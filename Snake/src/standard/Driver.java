package standard;

import framework.Game;
import framework.Position;
import java.awt.event.KeyEvent;

import java.io.IOException;

/**
 * Created by markn on 10-09-2017.
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException {
        Game game = new GameImp(new Position(10, 10));
        game.print();
        Thread.sleep(1000);

        game.moveUp();
        game.print();
        Thread.sleep(1000);

        game.moveUp();
        game.print();
        Thread.sleep(1000);

        game.moveRight();
        game.print();
        Thread.sleep(1000);

        game.moveRight();
        game.print();
        Thread.sleep(1000);

        game.moveRight();
        game.print();
        Thread.sleep(1000);

        game.moveRight();
        game.print();
        Thread.sleep(1000);

        game.moveDown();
        game.print();
        Thread.sleep(1000);

        game.moveDown();
        game.print();
        Thread.sleep(1000);

        game.moveDown();
        game.print();
        Thread.sleep(1000);





    }
}
