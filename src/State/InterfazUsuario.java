package State;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Game.GamePanel;
import res.Rutas.*;

public class InterfazUsuario {
  private State menu;
  private State play; 
  private State dead;
  private State pause;
  private State estadoActual;
  private JFrame ventana;
  private JPanel panel;
  private Rutas ruta;
  public InterfazUsuario(){
    this.menu = new Menu(this);
    this.play = new Play(this);
    this.dead = new Dead(this);
    this.pause = new Pause(this);
    this.estadoActual = this.play;
    iniciarVentana();
  }
  public void iniciarVentana(){
    ventana = new JFrame();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setResizable(false);
    ventana.setTitle("Call of Chienchias");
    if(System.getProperty("os.name").equals("Linux"))
      ruta = new Linux();
    else 
      ruta = new Windows();
  }
  protected JFrame getVentana() {
    return this.ventana;
  }
  protected Rutas getRuta(){
    return ruta;
  }
  protected JPanel getPanel(){
    return panel;
  }
  protected void setPanel(JPanel panel){
    this.panel = panel;
    ventana.add(panel);
    ventana.pack();
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
  }
  public State getEstado(){
    return this.estadoActual;
  }
  public void setEstado(State estado){
    this.estadoActual = estado;
  }
  public State getEstadoMenu(){
    return this.menu;
  }
  public State getEstadoPlay(){
    return this.play;
  }
  public State getEstadoDead(){
    return this.dead;
  }
  public State getEstadoPause(){
    return this.pause;
  }
  public void inicializar(){
    this.estadoActual.inicializar();
  }

}
