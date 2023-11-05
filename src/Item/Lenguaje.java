package Item; 

import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;
/*Clase abstracta que nos permite hacer uso de decorator, esta con el fin de encapsular las armas y los atributos que vaya adquiriendo 
 * el personaje a lo largo de la aventura */
public abstract class Lenguaje extends Player implements Armas{
  public Lenguaje(GamePanel gp, Keyboard kb) {
    super(gp, kb);
  }
protected Player player;
  // Regresa el ataque actual del arma 
  public int getAtaque(){
    return this.player.getAtaque();
  }
  // Regresa la velocidad actual del personaje 
  public int getVelocidad(){
    return this.player.getVelocidad();
  }
  // Regresa la cadencia actual del arma 
  public int getCadencia(){
    return this.player.getCadencia();
  }
  // Regresa la vida actual del personaje
  public int getVida(){
    return this.player.getVida();
  }
}
