package Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Conversation;
import Game.GamePanel;

public abstract class NPC implements Entity{
    GamePanel gp;
    int x, y, life, height, width;
    double speedX, speedY, gravity;
    BufferedImage imagen;
    String direction;
    boolean talking, collision, onfloor;
    ArrayList<Conversation> conversations;
    Conversation conversation;

    public NPC(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        conversations = new ArrayList<Conversation>();
        direction = "";
        speedX = 0.0;
        speedY = 0.0;
        gravity = 0.0;
        talking = false;
        getEntityImage();
    }
    /*
     * Obtiene las imagenes del personaje
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
        gp.cc.checkItem(this);
        gp.cc.checkNPC(this);
        boolean seePlayer = gp.cc.checkPlayer(this);
        onfloor = gp.cc.checkOnFloor(this);
        if (onfloor == false) {
            gravity = 0.2;
            speedY += gravity;
        }
        else{
            gravity = 0;
        }
        x+=speedX;
        y+=speedY;
        if(collision == false){
            switch(direction){
                case "left":
                    speedX = -5;
                    break;
                case "right":
                    speedX = 5;
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
    public void nextConversation(){
        if(!conversation.nextDialogue()){
            talking = false;
            conversation.setFinished(true);
            conversation = null;
        }
    }
    public void addConversation(String text){
        Conversation c = new Conversation(this, false);
        conversations.add(c);
    }
    public void talk(){
        conversation = getCurrentConversation();
        if(conversation!=null){
            conversation.setDialogue(0);
        }
        else{
            talking = false;
        }
    }
    public Conversation getCurrentConversation(){
        for(Conversation c: conversations){
            if(c.isAvailable()){
                return c;
            }
        }
        return null;
    }
    /*
     * Pinta al npc dentro del mapa
     * @param Graphics2D g2
     */
    public void paint(Graphics g){
        g.drawImage(imagen, x, y, width, height, gp);
        if(talking && conversation != null){
            conversation.paint(g);
        }
    }
    public boolean getCollision(){
        return collision;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public Rectangle getBox() {
        return new Rectangle(x,y,width,height);
    }
    public double getSpeedX(){
        return speedX;
    }
    public double getSpeedY(){
        return speedY;
    }
    public void setSpeedX(double speedX){
        this.speedX = speedX;
    }
    public void setSpeedY(double speedY){
        this.speedY = speedY;
    }
    public double getGravity(){
        return gravity;
    }

    public void setGravity(double gravity){
        this.gravity = gravity;
    }
    public Rectangle getBoxUp() {
        return new Rectangle(x+5, y, width-10, 1);
    }

    public Rectangle getBoxDown() {
        return new Rectangle(x+5, y + width - 1, width-10, 1);
    }

    public Rectangle getBoxRight() {
        return new Rectangle(x + height - 1, y+5, 1, height-10);
    }

    public Rectangle getBoxLeft() {
        return new Rectangle(x, y+5, 1, height-10);
    }
    @Override
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public boolean isOnFloor(){
        return onfloor;
    }
    public void setOnFloor(boolean onfloor){
        this.onfloor = onfloor;
    }
}
