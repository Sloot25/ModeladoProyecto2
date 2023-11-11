package Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import res.Rutas.Rutas;
import Game.GamePanel;
import Game.Keyboard;

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
    double gravity;
    Rectangle box;
    String direction;
    boolean collision;
    boolean jumping;
    boolean talking;
    boolean falling;
    boolean walking;
    boolean onfloor;

    public Player(GamePanel gp, Keyboard kb) {
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        box = new Rectangle(50, 50, width, height); // La caja es para revisar las colisiones
        collision = false;
        jumping = false;
        falling = true;
        walking = false;
        talking = false;
        onfloor = false;
        x = 0;
        y = 0;
        speedX = 0;
        speedY = 0;
        gravity = 0.2;
        direction = "right";
        life = 1000;
        getEntityImage();
    }

    public void getEntityImage() {
        try {
            image = ImageIO.read(new File("src\\res\\potato.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (kb.pressUp() == true) {
            direction = "up";
        } 
        else if (kb.pressDown() == true) {
            direction = "down";
        }  
        else if (kb.pressRight() == true) {
            direction = "right";
        }
        else if (kb.pressLeft() == true) {
            direction = "left";
        }
        else{
            direction = "";
        }
        gravity = 0.2;
        gp.cc.checkItem(this);
        switch (direction) {
            case "up":
                if (jumping || falling) {

                } else {
                    speedY = -10;
                    gravity = 0.2;
                    jumping = true;
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
        if (gravity <= 0 && jumping) {
            jumping = false;
        }
        if (!onfloor) {
            falling = true;
        } else {
            falling = false;
        }
        if (jumping || falling) {
            speedY += gravity;
        }
        y += speedY;
        x += speedX;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
        return new Rectangle(x+5, y + width - 1, width-10, 1);
    }

    public Rectangle getBoxRight() {
        return new Rectangle(x + height - 1, y, 1, height);
    }

    public Rectangle getBoxLeft() {
        return new Rectangle(x, y, 1, height);
    }

    @Override
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean getWalking() {
        return walking;
    }

    public void setWalking(boolean walking) {
        this.walking = walking;
    }

    public boolean getFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
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

}
