import javax.swing.JFrame;

import Game.GamePanel;
import res.Rutas.*;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Call of Chienchias");
        Rutas ruta;
        if(System.getProperty("os.name").equals("Linux"))
          ruta = new Linux();
        else 
          ruta = new Windows();
        GamePanel gp = new GamePanel(ruta);

        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.setGame();
        gp.startGameThread();
    }
}