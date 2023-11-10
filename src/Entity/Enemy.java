package Entity;
import java.lang.Cloneable;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.GamePanel;

public abstract class Enemy implements Entity, Cloneable{
    GamePanel gp;
    Player player;
    public int x;
    public int y;
    public int height;
    public int width;
    public BufferedImage image;
    public String direction;
    public int life;
    public Rectangle box = new Rectangle(0,0,128, 64);
    public int boxDefaultX;
    public int boxDefaultY;
    public int speedX;
    public int speedY;
    public Boolean collision;

    public Enemy(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        player = gp.player;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        Rectangle box = new Rectangle(x, y, width, height);
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        direction = "right";
        collision = false;
        getEntityImage();
    }

    /* 
     * Obtiene las imagenes del enemigo
     */
    public abstract void getEntityImage();
    /*
     * El villano ataca al jugador
     */
    public abstract void attack();
    /*
     * Actualiza la posicion y sprite del villano
     */
    public void update(){
        gp.cc.checkWalls(this);
        gp.cc.checkItem(this, false);
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
        g2.drawImage(image, (int)screenX, (int)screenY, width, height, null);
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
  abstract public Enemy clonar() throws CloneNotSupportedException;
}
