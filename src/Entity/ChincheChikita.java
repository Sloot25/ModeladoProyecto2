package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public class ChincheChikita extends Enemy{

    public ChincheChikita(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y , width, height);
    }

    public void getEntityImage(){
        try {
            image = ImageIO.read(new File("src\\res\\apple.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void attack() {
        gp.player.setLife(gp.player.getLife() - 100);
    }  
    public Enemy clonar() throws CloneNotSupportedException{
        return (Enemy) this.clone();
    }
}
