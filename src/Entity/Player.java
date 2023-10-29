package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;
import Game.Keyboard;

public class Player extends Entity{
    GamePanel gp;
    Keyboard kb;
    BufferedImage image;
    int x;
    int y;
    int screenX;
    int screenY;
    int speedX;
    int speedY;
    int width;
    int height;
    int score;
    int life;

    public Player(GamePanel gp, Keyboard kb){
        super(gp);
        this.gp = gp;
        this.kb = kb;
        height = 50;
        width = 50;
        screenX = gp.getWidth()/2 - width/2;
        screenY = gp.getHeight()/2 - height/2;
        box = new Rectangle(50,50,width,height);
        boxDefaultX = box.x;
        boxDefaultY = box.y;
        setDefaultValues();
        getPlayerImages();
    }
    
    public void setDefaultValues(){
        x = 50;
        y = 100;
        speedX = 0;
        speedY = 0;
        direction = "right";
        life = 100;
    }

    public void getPlayerImages(){
        try {
            image = ImageIO.read(new File("src\\res\\potato.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void update(){
        if(kb.pressUp() == true){
            direction = "up";
        }
        else if(kb.pressDown() == true){
            direction = "down";
        }
        else if(kb.pressRight() == true){
            direction = "right";
        }
        else if(kb.pressLeft() == true){
            direction = "left";
        }
        collision = false;
        if(collision == false){
            switch(direction){
                case "up":
                    y -= speedY;
                    break;
                case "down":
                    y += speedY;
                    break;
                case "left":
                    x -= speedX;
                    break;
                case "right":
                    x += speedX;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillRect(100, 100, 100, 100);
        int x = screenX;
        int y = screenY;
        if(screenX > x){
            x = (int) x;
        }
        if(screenY > y){
            y = (int) y;
        }
        if((gp.getScreenWidth()-screenX)>(gp.getWorldWidth()-x)){
            x = (int) (gp.getScreenWidth()-(gp.getWorldWidth()-x));
        }
        if((gp.getScreenHeight()-screenY)>(gp.getWorldHeight()-y)){
            y = (int) (gp.getScreenHeight()-(gp.getScreenHeight()-y));
        }
        g2.drawImage(image, x, y, width, height, null);
    }
}
