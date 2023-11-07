package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Conversation;
import Game.GamePanel;

public abstract class Enemy implements Entity, Cloneable{
    GamePanel gp;
    int x, y, speedX, speedY, life, height, width ;
    Double accel;
    BufferedImage image;
    String direction;
    Rectangle box = new Rectangle(0,0,50, 50);
    Boolean collision;
    ArrayList<Conversation> conversations;
    Conversation conversation;

    public Enemy(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        Rectangle box = new Rectangle(x, y, width, height);
        speedX = 0;
        speedY = 0;
        direction = "right";
        collision = false;
        getEnemyImages();
    }

    /* 
     * Obtiene las imagenes del enemigo
     */
    public abstract void getEnemyImages();
    /*
     * El villano ataca al jugador
     */
    public abstract void attack();
    /*
     * Actualiza la posicion y sprite del villano
     */
    public void update(){
        gp.cc.checkPlayer(this);
        gp.cc.checkItem(this);
        gp.cc.checkEntity(this, gp.npcs);
        gp.cc.checkEntity(this, gp.enemies);
        boolean attackPlayer = gp.cc.checkPlayer(this);
        if(collision == false){
            switch(direction){
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
        if(attackPlayer){
            attack();
        }
    }
    /*
     * Pinta al villano dentro del mapa
     * @param Graphics2D g2
     */
    public void paint(Graphics2D g2){
        g2.drawImage(image, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
    public boolean getCollision(){
        return collision;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
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
}
