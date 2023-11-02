package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelCreator {
    GamePanel gp;
    BufferedImage image;
    int x;
    int y;
    public LevelCreator(GamePanel gp){
        this.gp = gp;
        getPlayerImages();
    }

    public void getPlayerImages(){
    try {
        image = ImageIO.read(new File("src\\res\\cocina.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    public void paint(Graphics2D g2) {
        /*if(gp.player.getX() < gp.getScreenWidth()/2){
            x = 0;
        }
        else if(gp.player.getX() > gp.getWorldWidth() - gp.getScreenWidth()/2){
            x = gp.getWorldWidth() - gp.getScreenWidth();
        }*/
        //else{
            x = gp.player.getX()-gp.getScreenWidth()/2;
        //}
        /*if(gp.player.getY() < gp.getScreenHeight()/2){
            y = 0;
        }
        else if(gp.player.getY() > gp.getWorldHeight() - gp.getScreenHeight()/2){
            y = gp.getWorldHeight() - gp.getScreenHeight();
        }
        else{*/
            y = gp.player.getY()-gp.getScreenHeight()/2;
        //}
        g2.drawImage(image,x,y, gp.getWorldWidth(), gp.getWorldHeight(),null);
    }
    
}
