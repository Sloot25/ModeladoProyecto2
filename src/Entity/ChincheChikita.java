package Entity;

public class ChincheChikita extends Enemy {
  public void update(){}
  public void paint(Graphics2D g2){}
  public void attack();
  public Enemy clonar() throws CloneNotSupportedException{
    return(Enemy) this.clone();
  }
}
