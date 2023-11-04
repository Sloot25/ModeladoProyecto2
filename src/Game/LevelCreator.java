package Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import Entity.ChincheChikita;
import Entity.Enemy;
import Entity.EstudianteRandom;
import Entity.NPC;
import Entity.Entity;
import Item.Door;
import Item.Item;
import Item.WallFloor;

public class LevelCreator {
    GamePanel gp;
    BufferedImage image, image2;
    int x;
    int y;
    ArrayList<Item> items = new ArrayList <Item>();
    ArrayList<Entity> npcs = new ArrayList<Entity>();
    ArrayList<Entity> enemies = new ArrayList<Entity>();
    public LevelCreator(GamePanel gp){
        this.gp = gp;
        getPlayerImages();
        createLevel();
    }

    public void getPlayerImages() {
        try {
            image = ImageIO.read(new File("src\\res\\cocina.png"));
            image2 = ImageIO.read(new File("src\\res\\cocina2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createLevel(){
        int bloque = 10;
        for(int x=0; x<image2.getWidth(); x+=bloque){
            for(int y=0; y<image2.getHeight(); y+=bloque){
                int pixel = image2.getRGB(x,y);
                int red = (pixel>>16) & 0xff;
                int green = (pixel>>8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 255 && blue == 0 && green == 0){
                    items.add(new WallFloor(x, y, bloque, bloque, true, 0));
                }
                if(red == 0 && blue == 255 && green == 0){
                    items.add(new Door(x, y, bloque, bloque, true, 1));
                }
                if(red == 255 && blue == 0 && green == 255){
                    npcs.add(new EstudianteRandom(gp, x, y, 50, 50));
                }
                if(red == 0 && blue == 0 && green == 255){
                    enemies.add(new ChincheChikita(gp, x, y, 50, 50));
                }
            }
        }
    }
    public void paint(Graphics2D g2) {
        x = gp.player.getX()-gp.getScreenWidth()/2;
            y = gp.player.getY()-gp.getScreenHeight()/2;
        g2.drawImage(image,x,y, gp.getWorldWidth(), gp.getWorldHeight(),null);
    }
    
}
