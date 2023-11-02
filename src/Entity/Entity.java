package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Entity{
    public void update();
    public void paint(Graphics2D g2);
    public Rectangle getBox();
    public int getX();
    public int getY();
    public String getDirection();
    public int getSpeed();
    public void setCollision(boolean b);
    public int getBoxDefaultX();
    public int getBoxDefaultY();
}
