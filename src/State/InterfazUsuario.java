package State;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;

import Game.GamePanel;
import res.Rutas.*;
import Game.Keyboard;

public class InterfazUsuario {
  private State menu;
  private State play; 
  private State dead;
  private State pause;
  private State ganar;
  private State estadoActual;
  private JFrame ventana;
  private JPanel panel;
  private Rutas ruta;
  public InterfazUsuario(){
    this.menu = new Menu(this);
    this.play = new Play(this);
    this.dead = new Dead(this);
    this.pause = new Pause(this);
    this.ganar = new Ganar(this);
    this.estadoActual = this.menu;
    iniciarVentana();
  }
  // Inicializa la ventana del JFrame
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
  //@return JFrame la ventana en la que se mostraran los datos
  protected JFrame getVentana() {
    return this.ventana;
  }
  // @return Rutas regresa la ruta de escritura de archivos
  protected Rutas getRuta(){
    return ruta;
  }
  // JPanel Regresa el panel actual de juego
  protected JPanel getPanel(){
    return panel;
  }
  // @Param panel Setea un nuevo panel y lo inicializa
  protected void setPanel(JPanel panel){
    this.panel = panel;
    ventana.add(panel);
    ventana.pack();
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
  }
  // @return State regresa el estado actual de juego
  public State getEstado(){
    return this.estadoActual;
  }
  // @param State setea un nuevo estado como estado actual
  public void setEstado(State estado){
    this.estadoActual = estado;
  }
  // @return State regresa estado menu
  public State getEstadoMenu(){
    return this.menu;
  }
  //@return State regresa estado play
  public State getEstadoPlay(){
    return this.play;
  }
  
  //@return State regresa estado dead
  public State getEstadoDead(){
    return this.dead;
  }
  //@return State regresa estado pausar
  public State getEstadoPause(){
    return this.pause;
  }
  //@return State regresa estado ganar
  public State getEstadoGanar(){
    return this.ganar;
  }
  // Inicializa el estado actual
  public void inicializar(){
    this.estadoActual.inicializar();
  }
  // Llama al metodo menu del estadoActual
  public void menu(){
    estadoActual.menu();
  }
  // Llama al metodo jugar del estadoActual
  public void jugar(){
    estadoActual.jugar();
  }
  // Llama al metodo pausar del estadoActual
  public void pausar(){
    estadoActual.pausar();
  }
  // Llama al metodo morir del estadoActual
  public void morir(){
    estadoActual.morir();
  }
  // Llama al metodo ganar del estadoActual
  public void ganar(){
    estadoActual.ganar();
  }
  // Cambia el panel de juego para mostrar un nuevo panel en pantalla
  public void cambioPanel(JPanel panel){
    Container pane = ventana.getContentPane();
    pane.remove(this.panel);
    pane.add(panel);
    this.panel = panel;
    pane.revalidate();
  }

}
