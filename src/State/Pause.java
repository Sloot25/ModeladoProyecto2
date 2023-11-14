package State ;

import Game.GamePanel;

public class Pause implements State{
  InterfazUsuario interfaz; 
  public Pause(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  // setea el estado menu como estado actual en la interfaz
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  } 
  // setea el estado jugar como estado actual en la interfaz
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
  }
  // setea el estado morir como estado actual en la interfaz
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  // setea el estado pausar como estado actual en la interfaz
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }
  // setea el estado ganar como estado actual en la interfaz
  public void ganar(){
    this.interfaz.setEstado(this.interfaz.getEstadoGanar());
  }
  public void inicializar(){
  }

}
