package State ;

import Game.GamePanel;

public class Pause implements State{
  InterfazUsuario interfaz; 
  public Pause(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  } 
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }
  public void inicializar(){
  ((GamePanel)interfaz.getPanel()).setEstado(interfaz.getEstado());
  }

}
