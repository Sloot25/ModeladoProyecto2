package Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class StairsDown implements Item{
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    int id;
    Rectangle box;
    public StairsDown(int x, int y, int width, int height, boolean solid, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        box = new Rectangle(x,y,width, height);
    }

    @Override
    public void paint(Graphics g) {
        
    }

    @Override
    public boolean isSolid() {
        return solid;
    }

    @Override
    public Rectangle getBox() {
        return box;
    }
    
}
