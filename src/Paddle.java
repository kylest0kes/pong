import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterGraphics;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {

    int id;
    int yVelocity;

    Paddle(int x, int y, int PADDLE_W, int PADDLE_H, int id) {
        super(x, y, PADDLE_W, PADDLE_H);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void setYDirection(int yDirection) {

    }

    public void move() {

    }

    public void draw(Graphics g) {
        if(id == 1) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(x, y, width, height);
    }
}
