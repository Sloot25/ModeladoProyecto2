package Item;

import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class Java extends Lenguaje {
  public Java(Player player, GamePanel gp, Keyboard kb){
    super(gp, kb);
    this.player = player;
  }; 

  /* Metodo getAtaque 
   * @return int Correspondiente al ataque del arma
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

  /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  }
  public int getCadencia(){
    return this.player.getCadencia() + 10;
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return this.player.getLife() + 50;
  }
  public boolean isSolid(){
    return false;
  }
}
