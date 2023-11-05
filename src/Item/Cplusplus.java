package Item;
import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class Cplusplus extends Lenguaje {
  public Cplusplus(Player player, GamePanel gp, Keyboard kb){
    super(gp, kb);
    this.player = player;
  }

  /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getAtaque(){
    return this.player.getAtaque() + 25;
  }   

  /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return this.player.getVelocidad() + 5;
  }

  /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */
  
  public int getCadencia(){
    return this.player.getCadencia() + 15;
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return this.player.getVida() + 100;
  }
}
