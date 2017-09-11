package standard;

import framework.Direction;
import framework.Game;
import framework.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * https://stackoverflow.com/questions/9333876/how-to-simply-implement-a-keylistener
 */
public class GUI extends JPanel implements KeyListener {
    Game game;
    char c = 'w';

    public GUI() {
        game = new GameImp(new Position(10, 10));

        this.setPreferredSize(new Dimension(500, 500));
        addKeyListener(this);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawString("the key that pressed is " + c, 250, 250);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        repaint();

        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
	            game.moveSnake(Direction.UP);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
	            game.moveSnake(Direction.DOWN);
	            break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
	            game.moveSnake(Direction.LEFT);
	            break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
	            game.moveSnake(Direction.RIGHT);
	            break;
            default:
                //Do nothing
        }

        game.print();

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame f = new JFrame();
        f.getContentPane().add(new GUI());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
