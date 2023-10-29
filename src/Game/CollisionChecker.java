package Game;

import java.util.ArrayList;

import Entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public boolean checkPlayer(Entity entity) {
        boolean contactPlayer = false;
        entity.box.x = (int) (entity.getX() + entity.getBox().x);
        entity.box.y = (int) (entity.getY() + entity.getBox().y);
        gp.player.getBox().x =  (int) (gp.player.getX() + gp.player.getBox().x);
        gp.player.getBox().y =  (int) (gp.player.getY() + gp.player.getBox().y);
        switch(entity.direction){
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

    public void checkEntity(Entity entity, ArrayList<Entity> entities) {
    }

    public void checkItem(Entity entity, boolean b) {
    }

    public void checkTile(Entity entity) {
    }


    
}
