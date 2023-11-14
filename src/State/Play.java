package State;
import Game.GamePanel;
public class Play implements State {
  private InterfazUsuario interfaz; 
  GamePanel gp;
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
  }
  public void ganar(){
    this.interfaz.setEstado(this.interfaz.getEstadoGanar());
  }
  public void inicializar(){
    try{
      gp = new GamePanel(interfaz.getRuta(), interfaz);
      interfaz.cambioPanel(gp);
      gp.setGame();
      gp.startGameThread();
    }catch(CloneNotSupportedException e){
      System.err.println(e);
    }
  }

    
}
