package Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Entity{
    public void update();
    public void paint(Graphics g);
    public Rectangle getBox();
    public int getX();
    public int getY();
    public String getDirection();
    public Double getSpeedX();
    public Double getSpeedY();
    public void setSpeedX(Double speedX);
    public void setSpeedY(Double speedY);
    public Double getAccel();
    public void setAccel(Double accel);
    public boolean getCollision();
    public void setCollision(boolean collision);
    public Rectangle getBoxUp();
    public Rectangle getBoxDown();
    public Rectangle getBoxLeft();
    public Rectangle getBoxRight();
    public Boolean getJumping();
    public void setJumping(Boolean jumping);
    public Boolean getWalking();
    public void setWalking(Boolean walking);
    public Boolean getFalling() ;
    public void setFalling(Boolean falling);
}
