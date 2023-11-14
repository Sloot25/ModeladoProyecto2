package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Entity.Canek;
import Entity.ChincheChikita;
import Entity.ChincheDirector;
import Entity.ChincheGrandota;
import Entity.Chinchentifica;
import Entity.Enemy;
import Entity.Entity;
import Entity.EstudianteRandom;
import Entity.Lemus;
import Entity.NPC;
import Entity.Odin;
import Entity.Rosa;
import Entity.Vero;
import Item.Item;
import Item.StairsDown;
import Item.StairsUp;
import Item.WallFloor;

public class LevelCreator {
    GamePanel gp;
    BufferedImage image, map;
    int x, y, bloque, entitysize;
    ArrayList<Item> items = new ArrayList <Item>();
    ArrayList<NPC> npcs = new ArrayList<NPC>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Enemy[] BDEnemigos = new Enemy[4];
    public LevelCreator(GamePanel gp) throws CloneNotSupportedException{
        this.gp = gp;
        bloque = gp.getScale();
        entitysize = 10;
        loadEnemies();
        getMapImages();
        createLevel();
    }
    /*
     * Carga los enemigos que se van a requerir en el nivel, para poderlos clonar posteriormente
     */
    public void loadEnemies(){
        BDEnemigos[0] = new ChincheChikita(gp, 0,0,entitysize*bloque,entitysize*bloque);
        BDEnemigos[1] = new ChincheGrandota(gp, 0,0,2*entitysize*bloque,2*entitysize*bloque);
        BDEnemigos[2] = new Chinchentifica(gp, 0,0,entitysize*bloque,entitysize*bloque);
        BDEnemigos[3] = new ChincheDirector(gp, 0,0,3*entitysize*bloque,3*entitysize*bloque);
    }
    /*
     * Carga las imagenes del mapa y la información sobre la posición de los objetos
     */
    public void getMapImages() {
        image = gp.getRutas().getImagen("fciencias.png");
        map = gp.getRutas().getImagen("fcienciasmap.png");
    }
    /*
     * Regresa el arreglo de enemigos
     * @return ArrayList<Enemy>
     */
    public ArrayList<Enemy> getEnemys(){
     return this.enemies;
    }
    /*
     * Crea el nivel al colocar los objetos y entidades en las posiciones designadas en la imagen del mapa
     */
    public void createLevel() throws CloneNotSupportedException{
        for(int x=0; x<map.getWidth(); x++){
            for(int y=0; y<map.getHeight(); y++){
                int pixel = map.getRGB(x,y);
                int red = (pixel>>16) & 0xff;
                int green = (pixel>>8) & 0xff;
                int blue = (pixel) & 0xff;
                if(red == 255 && green == 255 && blue == 255){
                    gp.player.setX(bloque*x-150);
                    gp.player.setY(bloque*y);
                }
                else if(red == 237 && green == 28 && blue == 36){
                    items.add(new WallFloor(bloque*x, bloque*y, bloque, bloque, true, 0));
                }
                else if(red == 47 && green == 54 && blue == 153){
                    items.add(new StairsUp(gp, bloque*x+50, bloque*y+90, entitysize*bloque, entitysize*bloque, false, 1));
                }
                else if(red == 181 && green == 165 && blue == 213){
                    items.add(new StairsDown(gp, bloque*x+50, bloque*y+90, entitysize*bloque, entitysize*bloque, false, 2));
                }
                else if(red == 34 && green == 177 && blue == 76){
                    npcs.add(new EstudianteRandom(gp, bloque*x, bloque*y, entitysize*bloque, entitysize*bloque));
                }
                else if(red == 111 && green == 49 && blue == 152){
                    npcs.add(new Lemus(gp, bloque*x, bloque*y, 3*entitysize*bloque, 3*entitysize*bloque));
                }
                else if(red == 0 && green == 183 && blue == 239){
                    npcs.add(new Odin(gp, bloque*x, bloque*y, entitysize*bloque, entitysize*bloque));
                }
                else if(red == 255 && green == 194 && blue == 14){
                    npcs.add(new Vero(gp, bloque*x, bloque*y, entitysize*bloque, entitysize*bloque));
                }
                else if(red == 112 && green == 12 && blue == 44){
                    npcs.add(new Canek(gp, bloque*x, bloque*y, entitysize*bloque, entitysize*bloque));
                }
                else if(red == 84 && green == 109 && blue == 142){
                    npcs.add(new Rosa(gp, bloque*x, bloque*y, entitysize*bloque, entitysize*bloque));
                }
                else if(red == 255 && green == 242 && blue == 0){
                    enemies.add(BDEnemigos[0].clonar());
                    enemies.get(enemies.size()-1).setX(bloque*x);
                    enemies.get(enemies.size()-1).setY(bloque*y); 
                }
                else if(red == 67 && green == 230 && blue == 113){
                    enemies.add(BDEnemigos[2].clonar());
                    enemies.get(enemies.size()-1).setX(bloque*x);
                    enemies.get(enemies.size()-1).setY(bloque*y); 
                }
                else if(red == 255 && green == 126 && blue == 0){
                    enemies.add(BDEnemigos[1].clonar());
                    enemies.get(enemies.size()-1).setX(bloque*x);
                    enemies.get(enemies.size()-1).setY(bloque*y);
                }
                else if(red == 255 && green == 163 && blue == 177){
                    enemies.add(BDEnemigos[3].clonar());
                    enemies.get(enemies.size()-1).setX(bloque*x);
                    enemies.get(enemies.size()-1).setY(bloque*y);
                }
                else{

                }
            }
        }
    }
    /*
     * Actualiza las posiciones e información de las entidades
     */
    public void update(){
        for(Entity npc: npcs){
            npc.update();
        }
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
        }

    }
    /*
     * Pinta en el panel las imagenes de las entidades e items
     * @param Graphics 
     */
    public void paint(Graphics g) {
        g.drawImage(image,-50*bloque,-56*bloque, gp.getWorldWidth()+123*bloque, gp.getWorldHeight()+105*bloque,null);
        for(Entity npc: npcs){
            npc.paint(g);
        }
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).paint(g);
        }
        for(Item item: items){
            item.paint(g);
        }
    }
    
}
