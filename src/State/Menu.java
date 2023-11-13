package State;

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
  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void inicializar(){
    MenuInicio menu = new MenuInicio(interfaz.getRuta(), this);
    interfaz.setPanel(menu);
    //menu.startGameThread();

  }
}
