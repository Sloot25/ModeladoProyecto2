package Item;

import java.awt.Color;
import java.awt.Graphics2D;

public class Door implements Item{
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    int id;
    public Door(int x, int y, int width, int height, boolean solid, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillRect(x, y, width, height);
    }
    
}
