package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;
import Game.Keyboard;

public class Player implements Entity{
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    int speedX;
    Double speedY;
    int accel;
    int width;
    int height;
    int score;
    int vida;
    double gravity;
    Rectangle box;
    int boxDefaultX;
    int boxDefaultY;
    String direction;
    Boolean collision;
    Boolean jumping;

    public Player(GamePanel gp, Keyboard kb){
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        screenX = gp.getScreenWidth()/2 - width/2;
        screenY = gp.getScreenHeight()/2 - height/2;
        box = new Rectangle(50,50,width,height); //La caja es para revisar las colisiones
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        collision = false;
        jumping = false;
        setDefaultValues();
        getPlayerImages();
    }
    /*
     * 
     */
    public void setDefaultValues(){
        x = 400;
        y = 140;
        speedX = 0;
        speedY = 0.0;
        direction = "left";
        this.vida = 1000;
    }

    public void getPlayerImages(){
        try {
            image = ImageIO.read(new File("res/potato.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void update(){
        if(kb.pressUp() == true){
            direction = "up";
        }
        else if(kb.pressDown() == true){
            direction = "down";
        }
        else if(kb.pressRight() == true){
            direction = "right";
        }
        else if(kb.pressLeft() == true){
            direction = "left";
        }
        else{
            direction = "";
            speedX = 0;
            speedY = 0.0;
        }
        collision = false;
        if(gp.cc.checkWalls(this))
            collision = true;
        if(collision == false){
            switch(direction){
                case "up":
                    if(jumping){

                    }
                    else{
                    speedY = 8.0;
                    gravity = 0.2;
                    jumping = true;
                    }
                    break;
                case "down":
                    speedY = 0.0;
                    break;
                case "left":
                    speedX = 1*getVelocidad();
                    break;
                case "right":
                    speedX = -1*getVelocidad();
                    break;
            }
            if (jumping) {
                speedY -= gravity;
            }
            y += speedY;
            x += speedX;
        }
        else{
            speedY = 0.0;
            speedX = 0;
            y += 1;
            jumping = false;
            collision = false;
        }
    }

    public void paint(Graphics2D g2){
        int x = screenX;
        int y = screenY;
        if(screenX > x){
            x = (int) x;
        }
        if(screenY > y){
            y = (int) y;
        }
        if((gp.getScreenWidth()-screenX)>(gp.getWorldWidth()-x)){
            x = (int) (gp.getScreenWidth()-(gp.getWorldWidth()-x));
        }
        if((gp.getScreenHeight()-screenY)>(gp.getWorldHeight()-y)){
            y = (int) (gp.getScreenHeight()-(gp.getScreenHeight()-y));
        }
        g2.drawImage(image, x, y, width, height, null);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Rectangle getBox() {
        return box;
    }
    public int getSpeed() {
        return 0;
    }
    public void setCollision(boolean b) {
        collision = b;
    }
    public int getBoxDefaultX(){
        return boxDefaultX;
    }
    public int getBoxDefaultY(){
        return boxDefaultY;
    }
    @Override
    public String getDirection() {
        return direction;
    }
    
    
  public int getAtaque(){
    return 25;
  }
  public int getVelocidad(){
    return 5;
  }
  public int getCadencia(){
    return 10;
  }
  public int getVida(){
    return this.vida;
  }
}
