import javax.swing.JFrame;
import Game.GamePanel;

public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Patata moverse: el juego");

        GamePanel gp = new GamePanel();

        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.setGame();
        gp.startGameThread();
    }
}
