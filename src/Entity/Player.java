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
    Double speedX;
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
    Boolean talking;

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
        talking = false;
        x = 400;
        y = 140;
        speedX = 0.0;
        speedY = 0.0;
        direction = "right";
        vida = 1000;
        getPlayerImages();
    }

    public void getPlayerImages(){
      image = gp.getRutas().getImage();
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
            speedX = 0.0;
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
                    speedX = (double)1*getVelocidad();
                    break;
                case "right":
                    speedX = (double)-1*getVelocidad();
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
            speedX = 0.0;
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
        return getVelocidad();
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
    public int getVida() {
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }
    public BufferedImage getImage(){
        return image;
    }
    public int getScore() {
        return score;
    }
    public boolean isTalking() {
        return false;
    }
    public void startTalking(String mensaje){
        talking = true;
        gp.ui.talk(mensaje);
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
}
