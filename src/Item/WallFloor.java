package Item;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class WallFloor implements Item{
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    int id;
    public WallFloor(int x, int y, int width, int height, boolean solid, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(x, y, width, height);
    }
}
