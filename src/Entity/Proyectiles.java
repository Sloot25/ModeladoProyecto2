package Entity;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Proyectiles {
  private int velocidadX;
  private int posX; 
  private int posY; 
  private BufferedImage image;

  public Proyectiles(BufferedImage image, int velocidadX, int posX, int posY){
    this.image = image;
    this.velocidadX = velocidadX;
    this.posX = posX; 
    this.posY = posY;
  }
  public void update(){
    movimiento();
  }
  public void paint(Graphics g){
    g.drawImage(image, posX, posY, 20,20, null);
  }
  public void movimiento(){
    posX += velocidadX * 5; 
  }
  public Rectangle getBox(){
    return new Rectangle(posX, posY, 20, 20);
  }

  public int getVelocidad(){
    return velocidadX;
  }

}
