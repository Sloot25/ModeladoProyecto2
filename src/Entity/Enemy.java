package Entity;
import java.lang.Cloneable;

public abstract class Enemy implements Entity, Cloneable {
  GamePanel gp; 
  SpriteSheet sp; 
  int sprite; 
  int health; 
  int velocidad; 
  int x; 
  int y; 
  abstract public void update();
  abstract public void paint(Graphics2D g2);
  abstract public void attack();
  public Rectangule getBox();
  public int getX();
  public int getY();
  public String getDireccion();
  public int getSpeed();
  public void setCollision(boolean b);
  public int getBoxDefaultX();
  public int getBoxDefaultY();
  abstract public Enemy clonar() throws CloneNotSupportedException;
}
