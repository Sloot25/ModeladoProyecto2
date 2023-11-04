package Entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.GamePanel;

public class EstudianteRandom extends NPC {

    public EstudianteRandom(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
    } 

    public void getNPCImages(){
        try {
            image = ImageIO.read(new File("src\\res\\carrot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void interact() {
        gp.player.startTalking("Mi abuelo siempre decia Usa WASD para moverte");
        int time = 0;
        time++;
        if(time>120)
            gp.player.startTalking("Toma esto, te ayudara en tu viaje");
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
