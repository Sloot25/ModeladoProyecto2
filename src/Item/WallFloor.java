package Item;

import java.awt.Graphics;
import java.awt.Rectangle;

import Game.GamePanel;

public class WallFloor implements Item{
    GamePanel gp;
    int x;
    int y; 
    int width; 
    int height; 
    boolean solid;
    boolean inRange = false;
    int id;
    Rectangle box;
    public WallFloor(int x, int y, int width, int height, boolean solid, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.solid = solid;
        this.id = id;
        box = new Rectangle(x, y, width, height);
    }

    public boolean isSolid(){
        return solid;
    }

    public Rectangle getBox(){
        return box;
    }

    @Override
    public void paint(Graphics g) {
        //g.fillRect(x, y, width, height);
    }
    public boolean inRange(){
        return inRange;
    }
      public void setInRange(boolean inRange){
        this.inRange = inRange;
    }
}
