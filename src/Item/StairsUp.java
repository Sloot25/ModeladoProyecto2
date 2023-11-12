package Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    public void getImage(){
        imagen = gp.getRutas().getImagen("up.png");
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.PINK);
        if(inRange){
            g.drawImage(imagen,x,y-50,width, height, null);
        }
    }
    public boolean isSolid(){
        return solid;
    }
    public Rectangle getBox(){
        return box;
    }
    public boolean inRange(){
        return inRange;
    }
    public void setInRange(boolean inRange){
        this.inRange = inRange;
    }
}
