package Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Game.GamePanel;

public class StairsUp implements Item{
    GamePanel gp;
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    boolean inRange;
    int id;
    Rectangle box;
    BufferedImage imagen;
    public StairsUp(GamePanel gp, int x, int y, int width, int height, boolean solid, int id){
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        box = new Rectangle(x, y, width, height);
        getImage();
    }
    // lee e inicializa la imagen que llevan las escaleras (En este caso las flechas)
    public void getImage(){
        imagen = gp.getRutas().getImagen("up.png");
    }

    // Dibuja en pantalla la imagen en cuestion
    //@param Graphics para permitirle escribir en pantalla 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        if(inRange){
            g.drawImage(imagen,x,y-50,width, height, null);
        }
        else{
            
        }
    }
    //@return boolean si es solido o no en tiempo de ejecucion
    public boolean isSolid(){
        return solid;
    }
    // @return Rectangle devuelve la hitbox 
    public Rectangle getBox(){
        return box;
    }
    //@return boolean devuelve si se encuentra en rango
    public boolean inRange(){
        return inRange;
    }
    // @param boolean setea si se encuentra en rango
    public void setInRange(boolean inRange){
        this.inRange = inRange;
    }
}
