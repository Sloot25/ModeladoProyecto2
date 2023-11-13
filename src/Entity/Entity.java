package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity{
    public void update();
    public void paint(Graphics g);
    public Rectangle getBox();
    public int getX();
    public int getY();
    public void setY(int i);
    public void setX(int i);
    public String getDirection();
    public void setDirection(String direction);
    public void setCollision(boolean b);
    public boolean getCollision();
    public void getEntityImage();
    public Rectangle getBoxUp();
    public Rectangle getBoxDown();
    public Rectangle getBoxLeft();
    public Rectangle getBoxRight();
    public void setSpeedX(double d);
    public double getSpeedX();
    public void setSpeedY(double d);
    public double getSpeedY();
    public void setGravity(double d);
    public double getGravity();
    public void setOnFloor(boolean b);
    public boolean isOnFloor();
}
