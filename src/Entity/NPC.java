package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.GamePanel;

public abstract class NPC implements Entity{
    GamePanel gp;
    int worldX;
    int worldY;
    int height;
    int width;
    BufferedImage imagen;
    String direction;
    int life;
    Rectangle box = new Rectangle(0,0,50, 50);
    int boxDefaultX;
    int boxDefaultY;
    int speedX;
    int speedY;
    Boolean collision;

    public NPC(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.worldX = x; 
        this.worldY = y;
        this.width = width; 
        this.height = height;
        Rectangle box = new Rectangle(x, y, width, height);
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        direction = "left";
        collision = false;
        getEntityImage();
    }
    /*
     * Obtiene las imagenes del personaje
     * Metodo perteneciente a la interfaz entity
     */
    public abstract void getEntityImage();
    /*
     * El npc hace algo
     */
    public abstract void interact();

    /*
     * Actualiza la posicion y sprite del npc
     */
    public void update(){
        gp.cc.checkWalls(this);
        gp.cc.checkItem(this, false);
        gp.cc.checkEntity(this, gp.npcs);
        gp.cc.checkEntity(this, gp.enemies);
        boolean seePlayer = gp.cc.checkPlayer(this);

        if(collision == false){
            switch(direction){
                case "left":
                    worldY -= speedY;
                    break;
                case "right":
                    worldY += speedY;
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
        if(seePlayer){
            interact();
        }
    }
    /*
     * Pinta al npc dentro del mapa
     * @param Graphics2D g2
     */
    public void paint(Graphics2D g2){
        double screenX = worldX - gp.player.x + gp.player.screenX;
        double screenY = worldY - gp.player.y + gp.player.screenY;
        if(gp.player.screenX > gp.player.x){
            screenX = worldX;
        }
        if(gp.player.screenY > gp.player.y){
            screenY = worldY;
        }
        if((gp.getScreenWidth()-gp.player.screenX)>(gp.getWorldWidth()-gp.player.x)){
            screenX = gp.getScreenWidth()-(gp.getWorldWidth()-worldX);
        }
        if((gp.getScreenHeight()-gp.player.screenY)>(gp.getWorldHeight()-gp.player.y)){
            screenY = gp.getScreenHeight()-(gp.getWorldHeight()-worldY);
        }
        g2.drawImage(imagen, (int)screenX, (int)screenY, width, height, null);
    }
    public int getX() {
        return worldX;
    }
    public int getY() {
        return worldY;
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
}
