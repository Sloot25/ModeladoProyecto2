package Entity;

import Game.GamePanel;

public class ChincheDirector extends Enemy{
  private long ultimoAtaque;
  private long cooldown = 1000;
  private int points;

  public ChincheDirector(GamePanel gp, int x, int y, int width, int height) {
    super(gp, x, y , width, height);
    this.life = 4000;
    points = 5000;
  }

  public void attack(){
    long time = System.currentTimeMillis();
    if(time > ultimoAtaque + cooldown){
      gp.player.setLife(gp.player.getLife()-300);
      ultimoAtaque = time;
    }
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }

  @Override
  public void getEntityImage() {
    imagen = gp.getRutas().getImagen("chinchedirector.png");
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
}
