package Item;

import Entity.Player;
import Entity.AtributosPlayer;

public class Java extends Lenguaje {
  public Java(AtributosPlayer atributos, Player player){
    super(player);
    this.atributos = atributos;
    atributos.getPlayer().addImagenProyectil(atributos.getPlayer().getGP().getRutas().getImagen("Java.png"));
  }; 

  /* Metodo getAtaque 
   * @return int Correspondiente al ataque del arma
   * 
   * */

  public int getAtaque(){
    return atributos.getAtaque() + 25;
  }

  /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return atributos.getVelocidad() + 3;

  /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  }
  public int getCadencia(){
    return atributos.getCadencia() + 10;
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return atributos.getLife() + 50;
  }
}
