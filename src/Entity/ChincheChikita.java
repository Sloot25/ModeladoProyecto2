package Entity;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public class ChincheChikita extends Enemy{

  public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
      super(gp, x, y , width, height);
  }
  public void getEnemyImages(){
      try {
          image = ImageIO.read(new File(this.gp.getRutas().getChincheChiquita()));
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  @Override
  public void attack() {
      gp.player.setVida(gp.player.getVida() - 100);
  }  
  public void update(){}
  public void paint(Graphics2D g2){}
  public Enemy clonar() throws CloneNotSupportedException{
    return(Enemy) this.clone();
  }
}
