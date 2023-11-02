package Game;

import java.util.ArrayList;

import Entity.Entity;

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
        entity.getBox().x = (int) (entity.getX() + entity.getBox().x);
        entity.getBox().y = (int) (entity.getY() + entity.getBox().y);
        gp.player.getBox().x =  (int) (gp.player.getX() + gp.player.getBox().x);
        gp.player.getBox().y =  (int) (gp.player.getY() + gp.player.getBox().y);
        switch(entity.getDirection()){
            case "up":
                entity.getBox().y -= entity.getSpeed();
            break;
            case "down":
                entity.getBox().y += entity.getSpeed();
            break;
            case "left":
                entity.getBox().x -= entity.getSpeed();
            break;
            case "right":
                entity.getBox().y += entity.getSpeed();
            break;
        }    
        if(entity.getBox().intersects(gp.player.getBox())){
            entity.setCollision(true);
            contactPlayer = true;
        }
        entity.getBox().x = entity.getBoxDefaultX();
        entity.getBox().y = entity.getBoxDefaultY();
        gp.player.getBox().x = gp.player.getBoxDefaultX();
        gp.player.getBox().y = gp.player.getBoxDefaultY();    
        return contactPlayer;    
        
    }
    /*
     * Revisa si alguna entidad choco con otra
     */
    public boolean checkEntity(Entity entity, ArrayList<Entity> entities) {
        return false;
    }
    /*
     * Revisa si una entidad choca con un objeto
     */
    public boolean checkItem(Entity entity, boolean b) {
        return false;
    }
    /*
     * Revisa si alguna entidad ha chocado con una pared o piso
     */
    public boolean checkWalls(Entity entity) {
        if(entity.getY() < 140)
            return true;
        return false;
    }


    
}
