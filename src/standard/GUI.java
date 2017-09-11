package standard;

import framework.*;

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

    public GUI() {
        this.setPreferredSize(new Dimension(500, 500));
        addKeyListener(this);

        game = new GameImp(new Position(10, 10));

    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        //Draw border
        g.drawRect(1,1, Math.min(getWidth(), getHeight()) - 2, Math.min(getWidth(), getHeight()) - 2);

        //Calculate width of each cell;
        int delta = Math.min(this.getWidth(), this.getHeight()) / GameConstants.WORLD_SIZE;


        //Draw world item cells
        for (Position p : game.getWorldItems().keySet()) {
            if (game.getWorldItems().get(p) == WorldItem.APPLE) {
                addCell(g, Color.RED, p, delta);
            }
        }

        //Draw snake body
        for (Position p : game.getSnake().body) {
            addCell(g, Color.BLUE, p, delta);
        }

        //Draw snake head
        addCell(g, Color.BLACK, game.getSnake().getHead(), delta);


    }

    private void addCell(Graphics g, Color color, Position p, int delta){
        g.setColor(color);
        g.fillRect(p.getColumn() * delta, p.getRow() * delta, delta, delta);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        repaint();

        switch (e.getKeyCode()) {
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame f = new JFrame();
        f.getContentPane().add(new GUI());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
