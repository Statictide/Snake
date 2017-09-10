package standard;

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
        c = e.getKeyChar();
        repaint();

        switch (Character.toLowerCase(c)){
            case 'w':
                game.moveUp();
                break;
            case 's':
                game.moveDown();
                break;
            case 'a':
                game.moveLeft();
                break;
            case 'd':
                game.moveRight();
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
