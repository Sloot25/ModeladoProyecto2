package Item;

import Entity.AtributosPlayer;
import Entity.Player;

public class Python extends Lenguaje {
  public Python(AtributosPlayer atributos, Player player){
    super(player);
    this.atributos = atributos;
    atributos.getPlayer().addImagenProyectil(atributos.getPlayer().getGP().getRutas().getImagen("Python.png"));
  }

 /* Metodo getAtaque 
   * @return int Correspondiente aL ataque del arma
   * 
   * */

  public int getAtaque(){
    return atributos.getAtaque() + 50;
  }

 /* Metodo getVelocidad 
   * @return int Correspondiente a la velocidad del personaje
   * 
   * */

  public int getVelocidad(){
    return atributos.getVelocidad();
  }

 /* Metodo getCadencia 
   * @return int Correspondiente a la cadencia del arma
   * 
   * */

  public int getCadencia(){
    return atributos.getCadencia();
  }

  /* Metodo getVida 
   * @return int Correspondiente a la vida del personaje
   * 
   * */

  public int getVida(){
    return atributos.getLife() + 25;
  }
}
