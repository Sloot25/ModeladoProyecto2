package State;

import Game.Menu.WinScreen;

public class Ganar implements State {
  InterfazUsuario interfaz;
  public Ganar(InterfazUsuario interfaz){
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
  public void ganar(){
    this.interfaz.setEstado(this.interfaz.getEstadoGanar());
  }
  public void inicializar(){
    WinScreen ws = new WinScreen(interfaz.getRuta(), this);
    interfaz.setPanel(ws);
    ws.startGameThread();
  }
}
