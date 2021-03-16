import java.awt.*;

public class Score extends Rectangle {

    static int GAME_W;
    static int GAME_H;
    int player1;
    int player2;

    Score(int GAME_W, int GAME_H) {
        Score.GAME_W = GAME_W;
        Score.GAME_H = GAME_H;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times", Font.BOLD, 66));
        g.drawLine(GAME_W/2, 0, GAME_W/2, GAME_H);
        g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (GAME_W/2)-85, 50);
        g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (GAME_W/2)+20, 50);

    }
}
