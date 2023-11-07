package Item;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public abstract class Objeto implements Item {
    GamePanel gp;
    int x;
    int y; 
    int width; 
    int height; 
    BufferedImage image;
    boolean solid;
    int id;
    public Objeto(GamePanel gp, int x, int y, int width, int height, boolean solid, int id){
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
    }
    public void getObjectImage(){
        try {
            image = ImageIO.read(new File("res\\src\\apple"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics2D g2){
        g2.drawImage(image, x, y, width, height, null);
    }
    public boolean isSolid(){
        return solid;
    }
    public Rectangle getBox() {
        return new Rectangle(x,y,width,height);
    }
}
