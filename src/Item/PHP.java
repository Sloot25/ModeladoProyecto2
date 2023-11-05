package Item;
import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class PHP extends Lenguaje {
  public PHP(Player player, GamePanel gp, Keyboard kb){
    super(gp, kb);
    this.player = player;
  }

 /* Metodo getAtaque 
   * @return int Correspondiente aL ataque del arma
   * 
   * */

  public int getAtaque(){
    return this.player.getAtaque() - 10;
  }

 /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return this.player.getVelocidad() - 5;
  }

  /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return this.player.getCadencia() - 10;
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return this.player.getVida() + 100;
  }
    
}
