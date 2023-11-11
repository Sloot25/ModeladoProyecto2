package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import Entity.Canek;
import Entity.ChincheChikita;
import Entity.ChincheDirector;
import Entity.ChincheGrandota;
import Entity.Chinchentifica;
import Entity.Enemy;
import Entity.EstudianteRandom;
import Entity.Lemus;
import Entity.NPC;
import Entity.Odin;
import Entity.Rosa;
import Entity.Vero;
import Entity.Entity;
import Item.Item;
import Item.StairsUp;
import Item.WallFloor;

public class LevelCreator {
    GamePanel gp;
    BufferedImage image, map;
    int x, y, bloque;
    ArrayList<Item> items = new ArrayList <Item>();
    ArrayList<NPC> npcs = new ArrayList<NPC>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public LevelCreator(GamePanel gp){
        this.gp = gp;
        bloque = gp.getScale();
        getPlayerImages();
        createLevel();
    }

    public void getPlayerImages() {
        image = gp.getRutas().getImagen("fciencias.png");
        map = gp.getRutas().getImagen("fcienciasmap.png");
    }

    public void createLevel(){
        int npcsize = 10;
        for(int x=0; x<map.getWidth(); x++){
            for(int y=0; y<map.getHeight(); y++){
                int pixel = map.getRGB(x,y);
                int red = (pixel>>16) & 0xff;
                int green = (pixel>>8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 255 && green == 255 && blue == 255){
                    gp.player.setX(bloque*x-100);
                    gp.player.setY(bloque*y);
                }
                else if(red == 237 && green == 28 && blue == 36){
                    items.add(new WallFloor(bloque*x, bloque*y, bloque, bloque, true, 0));
                }
                else if(red == 47 && green == 54 && blue == 153){
                    items.add(new StairsUp(bloque*x, bloque*y, bloque, bloque, true, 1));
                }
                else if(red == 34 && green == 177 && blue == 76){
                    npcs.add(new EstudianteRandom(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 111 && green == 49 && blue == 152){
                    npcs.add(new Lemus(gp, bloque*x, bloque*y, 10*npcsize*bloque, 10*npcsize*bloque));
                }
                else if(red == 0 && green == 183 && blue == 239){
                    npcs.add(new Odin(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 255 && green == 194 && blue == 14){
                    npcs.add(new Vero(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 112 && green == 12 && blue == 44){
                    npcs.add(new Canek(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 84 && green == 109 && blue == 142){
                    npcs.add(new Rosa(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 255 && green == 242 && blue == 0){
                    enemies.add(new ChincheChikita(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 67 && green == 230 && blue == 113){
                    enemies.add(new Chinchentifica(gp, bloque*x, bloque*y, npcsize*bloque, npcsize*bloque));
                }
                else if(red == 255 && green == 126 && blue == 0){
                    enemies.add(new ChincheGrandota(gp, bloque*x, bloque*y, 2*npcsize*bloque, 2*npcsize*bloque));
                }
                else if(red == 255 && green == 163 && blue == 177){
                    enemies.add(new ChincheDirector(gp, x, y, npcsize*bloque, npcsize*bloque));
                }
                else{

                }
            }
        }
    }
    public void paint(Graphics g) {
        g.drawImage(image,0,0, gp.getWorldWidth(), gp.getWorldHeight(),null);
    }
    
}
