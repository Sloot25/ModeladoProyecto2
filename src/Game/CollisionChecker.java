package Game;

import java.util.ArrayList;

import Entity.Entity;
import Item.Item;
import Item.Objeto;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    /*
     * Revisa si el jugador ha chocado con alguna entidad
     */
    public boolean checkPlayer(Entity entity) {
        boolean contactPlayer = false;
        if(gp.player.getBox().intersects(entity.getBox())){
            entity.setCollision(true);
            contactPlayer = true;
        }
        return contactPlayer;    
    }
    /*
     * Revisa si alguna entidad choco con otra
     */
    public int checkEntity(Entity entity, ArrayList<Entity> entities) {
        int index = -1;
        int i = 0;
        for(Entity e: entities){
            i++;
            if(e!=null){
                if(e.getBox().intersects(entity.getBox())){
                    entity.setCollision(true);
                    index = i;
                }
            }
        }
        return index;
    }
    /*
     * Revisa si alguna entidad ha chocado con una pared o piso
     */
    public void checkItem(Entity entity) {
        for(Item i: gp.items){
            if(entity.getBoxUp().intersects(i.getBox())){
                entity.setSpeedY(0);
            }
            if(entity.getBoxDown().intersects(i.getBox())){
                entity.setSpeedY(0);
                entity.setAccel(0);
            }
        }
    }    
}
