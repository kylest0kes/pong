import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {

    Random random;
    int xVelocity;
    int yVelocity;
    int startSpeed = 3;

    Ball(int x, int y, int w, int h) {
        super(x, y, w, h);
        random = new Random();

        int randomXDir = random.nextInt(2);
        if(randomXDir == 0) {
            randomXDir--;
        }
        setXDirection(randomXDir * startSpeed);

        int randomYDir = random.nextInt(2);
        if(randomYDir == 0) {
            randomYDir--;
        }
        setYDirection(randomYDir * startSpeed);
    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
