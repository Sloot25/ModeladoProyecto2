package Entity;

import Game.GamePanel;

public class ChincheDirector extends Enemy{
  private long ultimoAtaque;
  private long cooldown = 1000;

  public ChincheDirector(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
    this.life = 4000;
    this.life = 800;
    this.retroceso = 0;
  }

  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-300);
      gp.player.setIsAtacked(true);
      gp.player.setRetroceso(400);
      ultimoAtaque = time; 
    }
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
  @Override
  public void getEntityImage(){
    if (isAtacked){
      imagen = this.gp.getRutas().getImagen("chinchedirector daniada.png");  
    } else{
      imagen = this.gp.getRutas().getImagen("chinchedirector.png");
    }
  }

  @Override
  public int getVelocidad(){
    return 2;
  }
  @Override
  public boolean inRange(){
    if(getX()-gp.player.getX() < 500){
      return true;
    }
    return false;
  }
  @Override
  public void retroceso(){
    if(retroceso <= 0){
      isAtacked = false; 
      retroceso = 100;
      getEntityImage();
    }else{
      retroceso -= 10; 
      getEntityImage();
    }
  }
}
