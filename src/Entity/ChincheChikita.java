package Entity;

import Game.GamePanel;

public class ChincheChikita extends Enemy{

  public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
  }
  @Override
  public void getEntityImage(){
    image = this.gp.getRutas().getImagen("apple.png");
  }
  @Override
  public void attack() {
      gp.player.setVida(gp.player.getVida() - 100);
  }  
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
}
