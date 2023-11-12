package Entity;

import Game.GamePanel;
public class Chinchentifica extends Enemy{

  public Chinchentifica(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
  }
  public void attack(){
    gp.player.setLife(gp.player.getLife()-200);
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinchentifica.png");
  }
}
