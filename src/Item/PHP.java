package Item;

import Entity.AtributosPlayer; 
import Entity.Player;

public class PHP extends Lenguaje {
  public PHP(AtributosPlayer atributos, Player player){
    super(player);
    this.atributos = atributos;
    atributos.getPlayer().addImagenProyectil(atributos.getPlayer().getGP().getRutas().getImagen("Php.png"));
  }

 /* Metodo getAtaque 
   * @return int Correspondiente aL ataque del arma
   * 
   * */

  public int getAtaque(){
    return atributos.getAtaque() - 10;
  }

 /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return atributos.getVelocidad() - 2;
  }

  /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return atributos.getCadencia() - 10;
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return atributos.getLife() + 100;
  }
}
