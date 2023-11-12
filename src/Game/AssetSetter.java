package Game;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setNPCs() {
        gp.npcs = gp.lc.npcs;
    }

    public void setEnemies() {
        gp.enemies = gp.lc.enemies;
    }

    public void setItems() {
        gp.items = gp.lc.items;
    }

}
