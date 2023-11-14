package State;


import Game.Menu.DeathScreen;

public class Dead implements State {
  InterfazUsuario interfaz;
  public Dead(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  // setea el estado menu como estado actual en la interfaz
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
    interfaz.inicializar();
  }
  // setea el estado jugar como estado actual en la interfaz
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
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
  //Inicializa el estado haciendo un cambio en el panel
  public void inicializar(){
    DeathScreen ds = new DeathScreen(interfaz.getRuta(), this);
    interfaz.cambioPanel(ds);
    ds.startGameThread(); 
  }
}
