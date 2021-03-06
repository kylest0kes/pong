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
        random = new Random();
        ball = new Ball((GAME_W/2) - (BALL_DIAMETER/2), random.nextInt(GAME_H - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles() {
        paddleP1 = new Paddle(10, (GAME_H/2)-(PADDLE_H/2), PADDLE_W, PADDLE_H, 1);
        paddleP2 = new Paddle((GAME_W-PADDLE_W) - 10, (GAME_H/2)-(PADDLE_H/2), PADDLE_W, PADDLE_H, 2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        paddleP1.draw(g);
        paddleP2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddleP1.move();
        paddleP2.move();
        ball.move();
    }

    public void checkCollision() {
        //BOUNCES BALL OFF PADDLES
        if(ball.intersects(paddleP1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //add speed
            if(ball.yVelocity > 0) {
                ball.yVelocity++; //add speed
            } else {
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if(ball.intersects(paddleP2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //add speed
            if(ball.yVelocity > 0) {
                ball.yVelocity++; //add speed
            } else {
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }


        //BOUNCES BALL OFF WINDOW EDGES
        if(ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_H - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        //STOPS PADDLES AT WINDOW EDGES
        if(paddleP1.y <= 0) {
            paddleP1.y = 0;
        }
        if(paddleP1.y >= (GAME_H-PADDLE_H)) {
            paddleP1.y = GAME_H-PADDLE_H;
        }
        if(paddleP2.y <= 0) {
            paddleP2.y = 0;
        }
        if(paddleP2.y >= (GAME_H-PADDLE_H)) {
            paddleP2.y = GAME_H-PADDLE_H;
        }

        //GIVES PLAYER POINT AND RESTARTS GAME
        if(ball.x <= 0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println(score.player2 + " " + score.player1);
        }
        if(ball.x >= GAME_W - BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println(score.player2 + " " + score.player1);
        }
    }

    public void run() {
        //GAME LOOP
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            paddleP1.keyPressed(e);
            paddleP2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddleP1.keyReleased(e);
            paddleP2.keyReleased(e);
        }
    }
}
