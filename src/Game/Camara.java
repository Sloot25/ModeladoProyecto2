package Game;

import Entity.Entity;

public class Camara {
    int x,y;
    public void update(GamePanel gp){
        setX(-gp.player.getX()+gp.getWidth()/2);
        setY(-gp.player.getY()+gp.getHeight()/2);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
