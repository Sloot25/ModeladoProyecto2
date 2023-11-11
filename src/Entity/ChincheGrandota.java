package Entity;

import Game.GamePanel;

public class ChincheGrandota extends Enemy{

  public ChincheGrandota(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
  }

  public void attack(){
    gp.player.setLife(gp.player.getLife()-150);
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy)this.clone();
  }

  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinche.png");
  }
}
