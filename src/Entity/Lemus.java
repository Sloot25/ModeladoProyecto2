package Entity;

import Game.GamePanel;

public class Lemus extends NPC {
  public Lemus(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }   
  public void getEntityImage(){
    imagen = gp.getRutas().getImagen("lemus.png");
  }
  public void interact(){
    gp.player.startTalking("¿Como vas con el proyecto? ");
  }
}
