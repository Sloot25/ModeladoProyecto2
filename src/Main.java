import javax.swing.JFrame;

import State.InterfazUsuario;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        InterfazUsuario interfaz = new InterfazUsuario();
        interfaz.inicializar();
        /*JFrame window = new JFrame();
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
        */
    }
}