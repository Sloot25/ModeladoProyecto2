package Item;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Item {
    public void paint(Graphics g);

	public boolean isSolid();

    public Rectangle getBox();

    public void setInRange(boolean b);
}
