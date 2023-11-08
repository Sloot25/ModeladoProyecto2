package Item;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Item {    
    public Rectangle getBox();
    public boolean isSolid();
    public int getID();
    public void paint(Graphics2D g2);
}
