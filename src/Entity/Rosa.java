package Entity;

import Game.GamePanel;

public class Rosa extends NPC {
  public Rosa(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("");
  }
  public void interact(){
    //Ingresar la interaccion con el personaje
  }
}
