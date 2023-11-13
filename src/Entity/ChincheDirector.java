package Entity;

import Game.GamePanel;

public class ChincheDirector extends Enemy{
  private long ultimoAtaque;
  private long cooldown = 1000;

  public ChincheDirector(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
  }

  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-300);
      ultimoAtaque = time;
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(200); // mayor retroceso, mas lejos te manda
    }
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }

  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinchedirector.png");
  }
}
