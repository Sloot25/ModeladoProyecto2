package State;


import Game.Menu.DeathScreen;

public class Dead implements State {
  InterfazUsuario interfaz;
  public Dead(InterfazUsuario interfaz){
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
    DeathScreen ds = new DeathScreen(interfaz.getRuta(), this);
    interfaz.setPanel(ds);
    ds.startGameThread(); 
  }
}
