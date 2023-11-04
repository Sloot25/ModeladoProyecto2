package Entity;

public class ChincheDirector extends Enemy{

  public ChincheDirector(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
  }

  public void attack(){
    gp.player.setVida(gp.player.getVida()-300);
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy) this.clone();
  }
}
