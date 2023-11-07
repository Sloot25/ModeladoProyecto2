package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Conversation;
import Game.GamePanel;

public abstract class NPC implements Entity{
    GamePanel gp;
    int x, y, speedX, speedY, life, height, width;
    Double accel;
    BufferedImage image;
    String direction;
    Boolean talking, collision;
    ArrayList<Conversation> conversations;
    Conversation conversation;

    public NPC(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        conversations = new ArrayList<Conversation>();
        direction = "left";
        talking = false;
        getNPCImages();
    }
    /*
     * Obtiene las imagenes del personaje
     */
    public abstract void getNPCImages();
    /*
     * El npc hace algo
     */
    public abstract void interact();

    /*
     * Actualiza la posicion y sprite del npc
     */
    public void update(){
        if(talking && conversation != null){
            conversation.update();
        }
    }
    public void nextConversation(){
        if(!conversation.nextDialogue()){
            talking = false;
            conversation.setFinished(true);
            conversation = null;
        }
    }
    public void addConversation(String path){
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
    public void paint(Graphics2D g2){
        g2.drawImage(image, x, y, width, height, gp);
        if(talking && conversation != null){
            conversation.paint(g2);
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
    public Rectangle getBox() {
        return new Rectangle(x,y,width,height);
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
}
