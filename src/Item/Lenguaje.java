package Item; 


import Entity.AtributosPlayer;
import Entity.Player;
/*Clase abstracta que nos permite hacer uso de decorator, esta con el fin de encapsular las armas y los atributos que vaya adquiriendo 
 * el personaje a lo largo de la aventura */
public abstract class Lenguaje extends AtributosPlayer implements Armas{
  boolean inRange = false;
  protected AtributosPlayer atributos;

  public Lenguaje(Player player){
    super(player);
  }
  public void setLife(int life){
    atributos.setLife(life);
  }
  // Regresa el ataque actual del arma 
  public int getAtaque(){
    return atributos.getAtaque();
  }
  // Regresa la velocidad actual del personaje 
  public int getVelocidad(){
    return atributos.getVelocidad();
  }
  // Regresa la cadencia actual del arma 
  public int getCadencia(){
    return atributos.getCadencia();
  }
  // Regresa la vida actual del personaje
  public int getLife(){
    return atributos.getLife();
  }
  public Player getPlayer(){
    return atributos.getPlayer();
  }
}
