package Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Conversation;
import Game.GamePanel;

public abstract class Enemy implements Entity, Cloneable{
    GamePanel gp;
    int x, y, life, height, width ;
    Double speedX, speedY;
    Double accel;
    BufferedImage image;
    String direction;
    Rectangle box = new Rectangle(0,0,50, 50);
    Boolean collision, jumping, falling, walking;
    ArrayList<Conversation> conversations;
    Conversation conversation;

    public Enemy(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        Rectangle box = new Rectangle(x, y, width, height);
        speedX = 5.0;
        speedY = 0.0;
        accel = 0.0;
        falling = true;
        direction = "left";
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
        if(falling)
            accel = 5.0;
        speedY += accel;
        gp.cc.checkItem(this);
        gp.cc.checkEnemy(this);
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
    public void paint(Graphics g){
        g.drawImage(image, x, y, width, height, null);
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
    public Double getSpeedX(){
        return speedX;
    }
    public Double getSpeedY(){
        return speedY;
    }
    public void setSpeedX(Double speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(Double speedY){
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
    public Boolean getJumping() {
        return jumping;
    }

    public void setJumping(Boolean jumping) {
        this.jumping = jumping;
    }

    public Boolean getWalking() {
        return walking;
    }

    public void setWalking(Boolean walking) {
        this.walking = walking;
    }

    public Boolean getFalling() {
        return falling;
    }

    public void setFalling(Boolean falling) {
        this.falling = falling;
    }
}
