package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import Game.GamePanel;
import Game.Keyboard;
import Game.SpriteSheet;

public class Player implements Entity {
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    double speedX;
    double speedY;
    int width;
    int height;
    int score;
    int life;
    int retroceso;
    double gravity;
    Rectangle box;
    String direction;
    boolean collision;
    //boolean jumping;
    boolean talking;
    //boolean falling;
    //boolean walking;
    boolean onfloor;
    boolean inMovement;
    boolean isAtacked;

    BufferedImage[] jugadorCaminando = new BufferedImage[10];
    BufferedImage[] jugadorParado = new BufferedImage[6];
    SpriteSheet animationCaminando, animationParado;
    BufferedImage jugadorDaniado;

    public Player(GamePanel gp, Keyboard kb) {
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        box = new Rectangle(50, 50, width, height); // La caja es para revisar las colisiones
        collision = false;
        talking = false;
        onfloor = false;
        x = 0;
        y = 0;
        speedX = 0;
        speedY = 0;
        gravity = 0;
        direction = "";
        life = 1000;
        inMovement = false;
        isAtacked = false;

        jugadorDaniado = this.gp.getRutas().getImagen("Jugador/Personaje danado.png");
        for(int i= 0; i < jugadorCaminando.length; i++){
            jugadorCaminando[i] = this.gp.getRutas().getImagen("Jugador/Personaje caminando "+(i+1)+".png");
        }
        for(int i= 0; i < jugadorParado.length; i++){
            jugadorParado[i] = this.gp.getRutas().getImagen("Jugador/Personaje "+(i+1)+".png");
        }
        animationCaminando = new SpriteSheet(jugadorCaminando,100);
        animationParado = new SpriteSheet(jugadorParado,100);

    }

    /*
     * Metodo para invertir una imagen horizontalmente
     * 
     * @param originalImage que será la imagen a voltear
     * 
     * @return flippedImage imagen volteada
     */
    private BufferedImage flipImage(BufferedImage originalImage){
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-originalImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage flippedImage = op.filter(originalImage, null);
        return flippedImage;
    }


     public void getEntityImage(){
        if (isAtacked){
            image = jugadorDaniado;
        }
        else if (inMovement){
            animationCaminando.update(); 
            if (direction == "right"){ // cuando el personaje tiene direccion de la imagen original, regresa original
                image =  animationCaminando.getCurrentFrame(); 
            } else{ //  regresa imagen volteada
                image = flipImage(animationCaminando.getCurrentFrame());
            }
        } else{
            animationParado.update(); 
            if (direction == "right"){ // cuando el personaje tiene direccion de la imagen original, regresa original
                image =  animationParado.getCurrentFrame(); 
            } else{ //  regresa imagen volteada
                image = flipImage(animationParado.getCurrentFrame());
            }
        }
     }

    /* 
    public void getEntityImage() {
      image = gp.getRutas().getImagen("potato.png");
    }
    */
    public void update() {
        getEntityImage();
        if (kb.pressUp() == true) {
            direction = "up";
            inMovement = true;
        } 
        else if (kb.pressDown() == true) {
            direction = "down";
            inMovement = true;
        }  
        else if (kb.pressRight() == true) {
            direction = "right";
            inMovement = true;
        }
        else if (kb.pressLeft() == true) {
            direction = "left";
            inMovement = true;
        }
        else{
            direction = "";
            inMovement = false;
        }
        onfloor = gp.cc.checkOnFloor(this);
        if (onfloor == false) {
            gravity = 0.2;
            speedY += gravity;
        }
        else{
            gravity = 0;
        }
        y += speedY;
        x += speedX;
        gp.cc.checkItem(this);
        gp.cc.checkStairs(this);

        if(isAtacked){ // si es atacado, solo te permite el retroceso
            retroceso();
        } else{  // si no es atacado, te permite moverte normal
            switch (direction) {
            case "up":
                if (onfloor) {
                    speedY = -10;
                    gravity = 0.2;
                    onfloor = false;
                }
                break;
            case "down":
                speedY = 0;
                break;
            case "left":
                speedX = -getVelocidad();
                break;
            case "right":
                speedX = getVelocidad();
                break;
            default:
                speedX = 0;
            }
        }

    }

    private void retroceso(){
        if(retroceso <= 0){
            isAtacked = false;
        } else{
            retroceso -= 10;
            speedX -= 2;
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
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
    public int getWidth(){
        return width;
    }

    public Rectangle getBox() {
        return new Rectangle(x, y, width, height);
    }

    public double getSpeedX() {
        return speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public Rectangle getBoxUp() {
        return new Rectangle(x+5, y, width-10, 1);
    }

    public Rectangle getBoxDown() {
        return new Rectangle(x+5, y + width - 5, width-10, 5);
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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isOnFloor() {
        return onfloor;
    }

    public void setOnFloor(boolean onfloor) {
        this.onfloor = onfloor;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getScore() {
        return score;
    }

    public boolean isTalking() {
        return false;
    }

    public void startTalking(String mensaje) {
        talking = true;
        gp.ui.talk(mensaje);
    }

    public int getAtaque() {
        return 25;
    }

    public int getVelocidad() {
        return 5;
    }

    public int getCadencia() {
        return 10;
    }

    public void setIsAtacked(Boolean isAtacked){
        this.isAtacked = isAtacked;
    }

    public Boolean getIsAtacked(){
        return isAtacked;
    }

    public void setRetroceso(int retroceso){
        this.retroceso = retroceso;
    }

}
