package Entity;

import Game.GamePanel;
public class Chinchentifica extends Enemy{
  private long cooldown = 2000;
  private long ultimoAtaque;


  public Chinchentifica(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
      this.life = 250;
  }
  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-200);
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(125); // mayor retroceso, mas lejos te manda
      ultimoAtaque = time;
    }

  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinchentifica.png");
  }
}
