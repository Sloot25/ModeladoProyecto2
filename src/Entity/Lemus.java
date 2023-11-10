package Entity;

import Game.GamePanel;

public class Lemus extends NPC {
  public Lemus(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }   
  public void getEntityImage(){
    this.gp.getRutas().getImagen("Lemus.png");
  }
  public void interact(){
    // TODO Ingresar las interacciones
  }
}
