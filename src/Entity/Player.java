package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Game.GamePanel;
import Game.Keyboard;
import Item.Objeto;

public class Player implements Entity{
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int speedX, speedY; 
    Double accel;
    int x, y,  width, height, life, score;
    Rectangle box;
    String direction;
    Boolean jumping, walking, falling, collision;

    public Player(GamePanel gp, Keyboard kb){
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        box = new Rectangle(50,50,width,height); //La caja es para revisar las colisiones
        jumping = false;
        x = 400;
        y = 50;
        speedX = 0;
        speedY = 0;
        direction = "right";
        life = 1000;
        getPlayerImages();
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
        else{
            direction = "";
            speedX = 0;
            speedY = 0;
        }
        gp.cc.checkItem(this);
        if(collision == false){
            switch(direction){
                case "up":
                    if(jumping){

                    }
                    else{
                    speedY = 8;
                    accel = 0.2;
                    jumping = true;
                    }
                    break;
                case "down":
                    speedY = 0;
                    break;
                case "left":
                    speedX = 5;
                    break;
                case "right":
                    speedX = -5;
                    break;
            }
            if (jumping) {
                speedY -= accel;
            }
        }
    }
    public boolean getCollision(){
        return collision;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
    }
    public void paint(Graphics2D g2){
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
    public int getSpeedX(){
        return speedX;
    }
    public int getSpeedY(){
        return speedY;
    }
    public void setSpeedX(int speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(int speedY){
        this.speedY = speedY;
    }
    public Double getAccel(){
        return accel;
    }
    public void setAccel(Double accel){
        this.accel = accel;
    }
    public Rectangle getBoxUp(){
        return new Rectangle(x,y,width,1);
    }
    public Rectangle getBoxDown(){
        return new Rectangle(x,y+width-1,width,1);
    }
    public Rectangle getBoxRight(){
        return new Rectangle(x+height-1,y,1,height);
    }
    public Rectangle getBoxLeft(){
        return new Rectangle(x,y,1,height);
    } 
    @Override
    public String getDirection() {
        return direction;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life){
        this.life = life;
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
}
