import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    GamePanel panel;

    GameWindow() {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
