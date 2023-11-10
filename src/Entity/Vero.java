package Entity;

import Game.GamePanel;

public class Vero extends NPC {
  public Vero(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("");
  }
  public void interact(){
    //Ingresar interacciones con el personaje 
  }
}
