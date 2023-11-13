package Entity;

import Game.GamePanel;

public class ChincheChikita extends Enemy{
  private long ultimoAtaque; 
  private long cooldown = 2000;
  private int points;
  public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
      this.life = 150;
      points = 100;
  }
  @Override
  public void getEntityImage(){
    imagen = this.gp.getRutas().getImagen("chinche.png");
  }
  @Override
  public void attack() {
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife() - 100);
      ultimoAtaque = time;
    }
  }  
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
}
