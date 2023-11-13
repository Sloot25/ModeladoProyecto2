package State;

import Game.GamePanel;
import Game.Menu.*;  

public class Menu implements State{
  InterfazUsuario interfaz; 

  public Menu(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  }
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
    this.interfaz.getEstado().inicializar();

  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void ganar(){
    this.interfaz.setEstado(this.interfaz.getEstadoGanar());
  }
  public void inicializar(){
    menuInicio();
  }
  public void menuInicio(){
    MenuInicio menu = new MenuInicio(interfaz.getRuta(), interfaz);
    interfaz.setPanel(menu);
    menu.startGameThread();
  }
  public void reglas(){
    Reglas reglas = new Reglas(interfaz.getRuta(), this);
    interfaz.cambioPanel(reglas);
    reglas.startGameThread();
  }
  public void creditos(){
    Creditos creditos = new Creditos(interfaz.getRuta(), this);
    interfaz.cambioPanel(creditos);
    creditos.startGameThread();
  }
  
}
