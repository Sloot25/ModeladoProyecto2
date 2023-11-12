package Entity;

import Game.GamePanel;

public class ChincheGrandota extends Enemy{
  private long cooldown = 1500; 
  private long ultimoAtaque;

  public ChincheGrandota(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
    this.life = 500;
  }

  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-150);
      ultimoAtaque = time;
    }
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy)this.clone();
  }

  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinche.png");
  }
}
