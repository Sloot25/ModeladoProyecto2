package State;

public class Play implements State {
  private InterfazUsuario interfaz; 

  public Play(InterfazUsuario interfaz){
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

    
}
