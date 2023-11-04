package Item;
import Entity.Player;

public class Python extends Lenguaje {
  public Python(Player player){
    this.player = player;
  }

 /* Metodo getAtaque 
   * @return int Correspondiente aL ataque del arma
   * 
   * */

  public int getAtaque(){
    return this.player.getAtaque() + 50;
  }

 /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return this.player.getVelocidad();
  }

 /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return this.player.getCadencia();
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return this.player.getVida() + 25;
  }
}
