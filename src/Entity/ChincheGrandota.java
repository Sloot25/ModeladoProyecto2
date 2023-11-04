package Entity;

public class ChincheGrandota extends Enemy{

  public ChincheGrandota(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
  }

  public void attack(){
    this.player.setVida(this.player.getVida()-150);
  }
  public Enemy clonar() throws CloneNotSupportedException{
    return (Enemy)this.clone();
  }
}
