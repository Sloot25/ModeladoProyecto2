package Entity;

import Game.GamePanel;

public class Odin extends NPC {
  public Odin(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getImage(){
    imagen = gp.getRutas().getImagen("");
  }
  public void getEntityImage(){
    //TODO Agregar imagen de Odin
  }
  public void interact(){
    // TODO Ingresa la interaccion de los personajes
  }
}
