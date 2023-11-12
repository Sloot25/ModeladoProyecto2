package Item;

import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class C extends Player{
  GamePanel gp;
  Keyboard kb;
  Player player;

  /*Constructor de la clase 
   * @param Player Recibe un objeto de tipo player y lo inicializa como variable de clase 
   * */

  public C(Player player, GamePanel gp, Keyboard kb){
    super(gp, kb);
    this.player = player;
  }

  /* Metodo getAtaque 
   * @return int Correspondiente al ataque del arma
   * 
   * */

  public int getAtaque(){
    return this.player.getAtaque() + 50;
  }

  /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del jugador
   * 
   * */

  public int getVelocidad(){
    return this.player.getVelocidad() + 15;
  }

  /* Metodo getCadencia
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return this.player.getCadencia() + 5; 
  }
  
  /* Metodo getVida
   * @return int Correspondiente a la vida del jugador
   * 
   * */

  public int getVida(){
    return this.player.getLife()+75;
  }
  
  public boolean isSolid(){
    return false;
  }
}
