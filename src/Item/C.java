package Item;
import Entity.Player;
public class C extends Lenguaje{

  /*Constructor de la clase 
   * @param Player Recibe un objeto de tipo player y lo inicializa como variable de clase 
   * */

  public C(Player player){
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
    return this.player.getVida()+75;
  }
}
