package State;
import Game.GamePanel;
public class Play implements State {
  private InterfazUsuario interfaz; 

  public Play(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  }
  public void jugar(){
    //Deberia lanzar la Exception que no hace nada, pero no recuerdo su nombre
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
    interfaz.gp.setEstado(interfaz.getEstado());
  }
  public void inicializar(){
    try{
      GamePanel gp = new GamePanel(interfaz.getRuta(), this);
      interfaz.setPanel(gp);
      gp.setGame();
      gp.startGameThread();
    }catch(CloneNotSupportedException e){
      System.err.println(e);
    }
  }

    
}
