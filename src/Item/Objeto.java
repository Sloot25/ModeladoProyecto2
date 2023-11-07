package Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public abstract class Objeto {
    GamePanel gp;
    int worldX;
    int worldY; 
    int width; 
    int height; 
    BufferedImage image;
    boolean solid;
    int id;
    public Objeto(GamePanel gp, int x, int y, int width, int height, boolean solid, int id){
        this.gp = gp;
        this.worldX = x;
        this.worldY = y;
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
        double screenX = worldX - gp.player.getX() + gp.player.getScreenX();
        double screenY = worldY - gp.player.getY() + gp.player.getScreenY();
        if(gp.player.getScreenX() > gp.player.getX()){
            screenX = worldX;
        }
        if(gp.player.getScreenY() > gp.player.getY()){
            screenY = worldY;
        }
        if((gp.getScreenWidth()-gp.player.getScreenX())>(gp.getWorldWidth()-gp.player.getX())){
            screenX = gp.getScreenWidth()-(gp.getWorldWidth()-worldX);
        }
        if((gp.getScreenHeight()-gp.player.getScreenY())>(gp.getWorldHeight()-gp.player.getY())){
            screenY = gp.getScreenHeight()-(gp.getWorldHeight()-worldY);
        }
        if(worldX + gp.player.getHeight() > gp.player.getX() - gp.player.getScreenX() && 
            worldX - gp.player.getHeight() < gp.player.getX() + gp.player.getScreenX() && 
            worldY + gp.player.getWidth() > gp.player.getY() - gp.player.getScreenY() && 
            worldY - gp.player.getWidth() < gp.player.getY() + gp.player.getScreenY()){
            g2.drawImage(image, (int)screenX, (int)screenY, width, height, null);
        }
        else if (gp.player.getScreenX() > gp.player.getX() || 
                gp.player.getScreenY() > gp.player.getY() || 
                (gp.getScreenWidth()-gp.player.getScreenX())>(gp.getWorldWidth()-gp.player.getX()) || 
                (gp.getScreenHeight()-gp.player.getScreenY())>(gp.getWorldHeight()-gp.player.getY())){
            g2.drawImage(image, (int)screenX, (int)screenY, width, height, null);
        } 
        g2.drawImage(image, (int)screenX, (int)screenY, width, height, null);
    }
}
