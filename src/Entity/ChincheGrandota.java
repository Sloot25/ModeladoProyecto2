package Entity;

import Game.GamePanel;

public class ChincheGrandota extends Enemy{
  private long cooldown = 1500; 
  private long ultimoAtaque;

  public ChincheGrandota(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
    this.life = 500;
    this.retroceso = 50;
  }

  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-150);
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(150); // mayor retroceso, mas lejos te manda
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
  @Override
  public void retroceso() {
      if(retroceso <= 0){
          isAtacked = false;
          retroceso = 50;
      } else{
          retroceso -= 10;
          speedX += 2;
      }
  }
}
