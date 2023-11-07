package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public class EstudianteRandom extends NPC {

    public EstudianteRandom(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
    } 

    public void interact(){
        
    }

    public void getNPCImages(){
        try {
            image = ImageIO.read(new File("src\\res\\carrot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override 
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
