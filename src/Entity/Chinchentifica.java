package Entity;

import Game.GamePanel;
public class Chinchentifica extends Enemy{
  private long cooldown = 2000;
  private long ultimoAtaque;

  public Chinchentifica(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
      this.life = 250;
      this.retroceso = 50;
  }
  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-200);
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(150);
      ultimoAtaque = time;
    }
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
  @Override
  public void getEntityImage() {
    if (isAtacked){
      imagen = this.gp.getRutas().getImagen("chinchentificadaniada.png");  
    } else{
      imagen = this.gp.getRutas().getImagen("chinchentifica.png");
    }
  }
  @Override
  public void retroceso(){
    if(retroceso <= 0){
      isAtacked = false; 
      retroceso = 50;
      getEntityImage();
    }else{
      retroceso -= 10;
      x += 5 * directionReceivedAtack;;
      getEntityImage();
    }
  }
}
