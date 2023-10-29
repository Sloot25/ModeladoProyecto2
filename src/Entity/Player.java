package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;
import Game.Keyboard;

public class Player{
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    int speedX;
    int speedY;
    int width;
    int height;
    int score;
    int life;
    Rectangle box;
    int boxDefaultX;
    int boxDefaultY;
    String direction;
    Boolean collision;

    public Player(GamePanel gp, Keyboard kb){
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        screenX = gp.getScreenWidth()/2 - width/2;
        screenY = gp.getScreenHeight()/2 - height/2;
        box = new Rectangle(50,50,width,height);
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        collision = false;
        setDefaultValues();
        getPlayerImages();
    }
    
    public void setDefaultValues(){
        x = 200;
        y = 200;
        speedX = 5;
        speedY = 5;
        direction = "left";
        life = 100;
    }

    public void getPlayerImages(){
        try {
            image = ImageIO.read(new File("src\\res\\potato.png"));
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
        collision = false;
        if(collision == false){
            switch(direction){
                case "up":
                    screenY -= speedY;
                    break;
                case "down":
                    screenY += speedY;
                    break;
                case "left":
                    screenX -= speedX;
                    break;
                case "right":
                    screenX += speedX;
                    break;
            }
        }
    }

    public void paint(Graphics2D g2){
        int x = screenX;
        int y = screenY;
        /*
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
        */
        g2.drawImage(image, x, y, width, height, null);
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
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
}
