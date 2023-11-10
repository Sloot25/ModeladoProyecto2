package Item;

import java.awt.Color;
import java.awt.Graphics2D;

public class StairsDown implements Item{
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    int id;
    public StairsDown(int x, int y, int width, int height, boolean solid, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
    }

    @Override
    public void paint(Graphics2D g2) {
        
    }
    
}
