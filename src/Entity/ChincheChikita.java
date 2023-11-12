package Entity;

import Game.GamePanel;

public class ChincheChikita extends Enemy{

    public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y , width, height);
    }

    public void getEntityImage(){
        imagen = gp.getRutas().getImagen("chinche.png");
    }

    @Override
    public void attack() {
        gp.player.setLife(gp.player.getLife() - 100);
    }  
    public Enemy clonar() throws CloneNotSupportedException{
        return (Enemy) this.clone();
    }
}
