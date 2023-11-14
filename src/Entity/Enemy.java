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
    int directionReceivedAtack;
    

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
        isAtacked = false;
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

    public abstract void retroceso();
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
    /*
     * Regresa si se ha atacado a un enemigo
     * @return isAttacked
     */
    public void setIsAtacked(boolean isAtacked){
      this.isAtacked = isAtacked;
    }
    /*
     * Pinta al enemigo en su posición
     * @param Graphics g
     */
    public void paint(Graphics g){
        g.drawImage(imagen, x, y, width, height, null);
        if(inRange()){ //Pinta la barra de vida del jefe final
            g.setColor(Color.BLACK);
            g.drawString("Chinche Director",gp.player.getX()-300, gp.player.getY()+85);
            g.setColor(Color.RED);
            g.fillRoundRect(gp.player.getX()-300, gp.player.getY()+100, getLife()*600/4000, 30,15,15 );
        }
    }
    /*
     * Regresa si hay una colision
     * @return collision
     */
    public boolean getCollision(){
        return collision;
    }
    /*
     * Alterna si hay  alguna colision
     * @param collision
     */
    public void setCollision(boolean collision){
        this.collision = collision;
    }
    /*
     * Regresa la posicion x del enemigo
     * @return
     */
    public int getX() {
        return x;
    }
    /*
     * Regresa la posicion y del enemigo
     * @return y
     */
    public int getY() {
        return y;
    }
    /*
     * Modifica la posición x del enemigo
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }
    /*
     * Modifica la posicion y del enemigo
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }
    /* 
     * Regresa la caja de colisiones del enemigo
     * @return box
     */
    public Rectangle getBox() {
        return new Rectangle(x,y,width,height);
    }
    /*
     * Regresa la velocidad con la que se mueve la posición X
     * @return double x
     */
    public double getSpeedX(){
        return speedX;
    }
    /*
     * Regresa la velocidad con la que se mueve la posición y
     * @return double y
     */
    public double getSpeedY(){
        return speedY;
    }
    /*
     * Modifica la velocidad de la posición x
     * @param speedX
     */
    public void setSpeedX(double speedX){
        this.speedX = speedX;
    }
    /*
     * Modifica la velocidad de la posición y
     * @param speedY
     */
    public void setSpeedY(double speedY){
        this.speedY = speedY;
    }
    /*
     * Regresa la aceleración de la gravedad con la que cambia la velocidad de y
     * @return gravity
     */
    public double getGravity(){
        return gravity;
    }
    /*
     * Modifica la aceleración de la gravedad con la que cambia la velocidad de y
     * @param gravity
     */
    public void setGravity(double gravity){
        this.gravity = gravity;
    }
    /*
     * Regresa la caja de colisiones superiores del enemigo
     * @return rectangle
     */
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
    public void setIsAtacked(Boolean isAtacked){
        this.isAtacked = isAtacked;
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
