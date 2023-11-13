package Entity;

import Game.GamePanel;

public class EstudianteRandom extends NPC {

    public EstudianteRandom(GamePanel gp, int x, int y, int width, int height) {
        super(gp, x, y, width, height);
    } 

    public void getEntityImage(){
      imagen = gp.getRutas().getImagen("estudiante.png");
    }

    @Override
    public void interact() {
        gp.player.startTalking("Mi abuelo siempre decia Usa las flechas para moverte");
        int time = 0;
        time++;
        if(time>20)
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
