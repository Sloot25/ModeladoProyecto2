package Entity;

import Game.GamePanel;

public class ChincheDirector extends Enemy{

  public ChincheDirector(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
  }

  public void attack(){
    gp.player.setLife(gp.player.getLife()-300);
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }

  @Override
  public void getEntityImage() {
    image = gp.getRutas().getImagen("naranja.png");
  }
}
