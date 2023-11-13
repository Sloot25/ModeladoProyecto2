package Entity;
import java.lang.Cloneable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import Game.GamePanel;
import Game.SpriteSheet;

public abstract class Enemy implements Entity, Cloneable{
    GamePanel gp;
    Player player;
    public int x;
    public int y;
    public int height;
    public int width;
    private int points;
    public BufferedImage imagen;
    public String direction;
    public int life;
    double speedX;
    double speedY;
    double gravity;
    boolean collision;
    boolean onfloor;
    SpriteSheet sprites; 
    boolean isAtacked;
    int retroceso;
    

    public Enemy(GamePanel gp, int x, int y, int width, int height){
        this.gp = gp;
        player = gp.player;
        this.x = x; 
        this.y = y;
        this.width = width; 
        this.height = height;
        this.gravity = 5;
        direction = "left";
        onfloor = false;
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
        gp.cc.checkItem(this);
        gp.cc.checkEnemy(this);
        gp.cc.checkProyectil(this);
        gp.cc.checkAliados(this);
        boolean attackPlayer = gp.cc.checkPlayer(this);
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
                    speedX = -getVelocidad();
                    break;
                case "right":
                    speedX = getVelocidad();
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
        if(isAtacked)
          retroceso();
    }
    public void setIsAtacked(boolean isAtacked){
      this.isAtacked = isAtacked;
    }

    public abstract void retroceso();
    /*
     * Pinta al villano dentro del mapa
     * @param Graphics2D g2
     */
    public void paint(Graphics g){
        g.drawImage(imagen, x, y, width, height, null);
        if(inRange()){
            g.setColor(Color.BLACK);
            g.drawString("Chinche Director",gp.player.getX()-300, gp.player.getY()+85);
            g.setColor(Color.RED);
            g.fillRoundRect(gp.player.getX()-300, gp.player.getY()+100, getLife()*600/4000, 30,15,15 );
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
  abstract public Enemy clonar() throws CloneNotSupportedException;

    public int getLife() {
        return life;
    }

    public int getVelocidad(){
        return 1;
    }
    public int getPoints(){
        return points;
    }

    public void setLife(int life) {
        this.life = life;
    }
    public boolean inRange(){
        return false;
    }
}
