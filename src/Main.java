import javax.swing.JFrame;

import Game.GamePanel;
import res.Rutas.*;
public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Patata moverse: el juego");
        Rutas ruta = null;
        switch (System.getProperty("os.name")) {
          case "Linux":
            ruta = new Linux();
            break;
          case "Windows":
            ruta = new Windows;
            break;
        }

        GamePanel gp = new GamePanel(ruta);

        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.setGame();
        gp.startGameThread();
    }
}
