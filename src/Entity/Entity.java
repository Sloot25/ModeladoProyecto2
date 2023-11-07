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
    public int getSpeedX();
    public int getSpeedY();
    public void setSpeedX(int speedX);
    public void setSpeedY(int speedY);
    public Double getAccel();
    public void setAccel(Double Accel);
    public boolean getCollision();
    public void setCollision(boolean collision);
    public Rectangle getBoxUp();
    public Rectangle getBoxDown();
    public Rectangle getBoxLeft();
    public Rectangle getBoxRight();
}
