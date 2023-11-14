package State;

import Game.GamePanel;
import Game.Menu.*;  

public class Menu implements State{
  InterfazUsuario interfaz; 

  public Menu(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  // setea el estado menu como estado actual en la interfaz
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  }
  // setea el estado jugar como estado actual en la interfaz
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
    this.interfaz.getEstado().inicializar();

  }
  // setea el estado pausar como estado actual en la interfaz
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }
  // setea el estado morir como estado actual en la interfaz
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  // setea el estado ganar como estado actual en la interfaz
  public void ganar(){
    this.interfaz.setEstado(this.interfaz.getEstadoGanar());
  }
    // inicializa el estado haciendo un seteo del paneel
  public void inicializar(){
    menuInicio();
  }
  public void menuInicio(){
    MenuInicio menu = new MenuInicio(interfaz.getRuta(), this);
    interfaz.setPanel(menu);
    menu.startGameThread();
  }
  //Inicializa una nueva pantalla haciendo un cambioPanel
  public void reglas(){
    Reglas reglas = new Reglas(interfaz.getRuta(), this);
    interfaz.cambioPanel(reglas);
    reglas.startGameThread();
  }
  //Inicializa una nueva pantallla haciendo un cambioPanel
  public void creditos(){
    Creditos creditos = new Creditos(interfaz.getRuta(), this);
    interfaz.cambioPanel(creditos);
    creditos.startGameThread();
  }
  
}
