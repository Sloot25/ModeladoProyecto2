package Entity;

public class Odin extends NPC {
  public Odin(GamePanel gp, int x, int y, int width, int height){
    super(gp, x, y, width, height);
  }
  public void getImage(){
    image = gp.getRutas().getImage("");
  }
  public void interact(){
    // Ingresa la interaccion de los personajes
  }
}
