package Game;

import java.util.ArrayList;

import Entity.Enemy;
import Entity.Entity;
import Entity.NPC;
import Item.Item;

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
    public void checkNPC(NPC n) {
            if(n!=null){
                if(n.getBox().intersects(gp.player.getBox())){
                    gp.player.setCollision(true);
                    n.interact();
                }
            }
        }
    public void checkEnemy(Enemy e){
            if(e!=null){
                if(e.getBox().intersects(gp.player.getBox())){
                    gp.player.setCollision(true);
                    e.attack();
                }
            }
        }
    /*
     * Revisa si alguna entidad ha chocado con una pared o piso
     */
    public void checkItem(Entity entity) {
        for(Item i: gp.items){
            if(i.isSolid()){
                if(entity.getBoxUp().intersects(i.getBox())){
                    entity.setSpeedY(0);
                }
                if(entity.getBoxDown().intersects(i.getBox())){
                    entity.setSpeedY(0);
                    entity.setOnFloor(true);
                }
                if(entity.getBoxLeft().intersects(i.getBox())){
                    entity.setSpeedX(-entity.getSpeedX());
                    entity.setCollision(true);
                    entity.setY(entity.getY()-1);
                    entity.setDirection("right");
                }
                if(entity.getBoxRight().intersects(i.getBox())){
                    entity.setSpeedX(-entity.getSpeedX());
                    entity.setY(entity.getY()-1);
                    entity.setCollision(true);
                    entity.setDirection("left");
                }
            }
        }
    }
    public boolean checkOnFloor(Entity entity){
        for(Item i: gp.items){
                if(entity.getBoxDown().intersects(i.getBox())){
                return true;
            }
        }
        return false;
    }
}
