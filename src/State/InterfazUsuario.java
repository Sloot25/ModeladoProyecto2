package State;

public class InterfazUsuario {
  private State menu;
  private State play; 
  private State dead;
  private State pause;
  private State estadoActual;

  public InterfazUsuario(){
    this.menu = new Menu(this);
    this.play = new Play(this);
    this.dead = new Dead(this);
    this.pause = new Pause(this);
    this.estadoActual = this.menu;
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

}
