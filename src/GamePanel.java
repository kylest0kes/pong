import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_W = 1000;
    static final int GAME_H = (int)(GAME_W * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_W, GAME_H);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_W = 25;
    static final int PADDLE_H = 100;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddleP1;
    Paddle paddleP2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_W, GAME_H);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {

    }

    public void newPaddles() {

    }

    public void paint(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void move() {

    }

    public void checkCollision() {

    }

    public void run() {

    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {

        }
    }
}
