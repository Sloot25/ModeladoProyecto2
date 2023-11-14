package Item;

import Entity.Player;
import Entity.AtributosPlayer;

public class C extends Lenguaje{
  /*Constructor de la clase 
   * @param Player Recibe un objeto de tipo player y lo inicializa como variable de clase 
   * */

  public C(AtributosPlayer atributos, Player player){
    super(player);
    this.atributos = atributos;
    atributos.getPlayer().addImagenProyectil(atributos.getPlayer().getGP().getRutas().getImagen("C.png"));
  }

  /* Metodo getAtaque 
   * @return int Correspondiente al ataque del arma
   * 
   * */

  public int getAtaque(){
    return atributos.getAtaque() + 50;
  }

  /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del jugador
   * 
   * */

  public int getVelocidad(){
    return atributos.getVelocidad() + 2;
  }

  /* Metodo getCadencia
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return atributos.getCadencia() + 5; 
  }
  
  /* Metodo getVida
   * @return int Correspondiente a la vida del jugador
   * 
   * */

  public int getVida(){
    return atributos.getLife()+75;
  }
}
