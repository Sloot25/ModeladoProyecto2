package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.GamePanel;

public abstract class Entity implements Cloneable{
    GamePanel gp;
    public double x;
    public double y;
    public int height;
    public int width;
    public BufferedImage pic;
    public String direction;
    public int life;
    public Rectangle box = new Rectangle(0,0,128, 64);
    public int boxDefaultX;
    public int boxDefaultY;
    public double speedX;
    public double speedY;
    public Boolean collision;

    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void setAction(){

    }
    public void update(){
        setAction();
        gp.cc.checkTile(this);
        gp.cc.checkItem(this, false);
        gp.cc.checkEntity(this, gp.npcs);
        gp.cc.checkEntity(this, gp.enemies);
        boolean seePlayer = gp.cc.checkPlayer(this);
        if(collision == false){
            switch(direction){
                case "up":
                    x -= speedX;
                    break;
                case "down":
                    x += speedX;
                    break;
                case "left":
                    y -= speedY;
                    break;
                case "right":
                    y += speedY;
                    break;
            }
        }
        if(collision == true){
            switch(direction){
                case "up":
                    direction = "down";
                    collision = false;
                    break;
                case "down":
                    direction = "up";
                    collision = false;
                    break;
                case "left":
                    direction = "right";
                    collision = false;
                    break;
                case "right":
                    direction = "left";
                    collision = false;
                    break;
            }
        }
    }

    public void paint(Graphics2D g2){
        double screenX = x - gp.player.x + gp.player.screenX;
        double screenY = y - gp.player.y + gp.player.screenY;
        if(gp.player.screenX > gp.player.x){
            screenX = x;
        }
        if(gp.player.screenY > gp.player.y){
            screenY = y;
        }
        if((gp.getScreenWidth()-gp.player.screenX)>(gp.getWorldWidth()-gp.player.x)){
            screenX = gp.getScreenWidth()-(gp.getWorldWidth()-x);
        }
        if((gp.getScreenHeight()-gp.player.screenY)>(gp.getWorldHeight()-gp.player.y)){
            screenY = gp.getScreenHeight()-(gp.getWorldHeight()-y);
        }
            g2.drawImage(pic, (int)screenX, (int)screenY, width, height, null);
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
