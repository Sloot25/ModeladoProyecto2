package Aliados;

import java.awt.Graphics;

import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class Telefono {
    Keyboard kb;
    GamePanel gp;
    Player player;
    Actuario actuario;
    Biologo biologo;
    Computologo computologo;
    Fisico fisico;
    Matematico matematico;
    int counter = 0;

    public Telefono(GamePanel gp, Player player, Keyboard kb){
        this.gp = gp;
        this.player = player;
        this.kb = kb;
        setPhone();
    }
    public void setPhone(){
        actuario = new Actuario(gp, player);
        biologo = new Biologo(gp, player);
        computologo = new Computologo(gp, player);
        fisico = new Fisico(gp, player);
        matematico = new Matematico(gp, player);
    }
    public void paint(Graphics g){
        Aliado aliado = null;
        if(gp.kb.press1()){
            aliado = actuario;
        }
        if(gp.kb.press2()){
            aliado = biologo;
        }
        if(gp.kb.press3()){
            aliado = computologo;
        }
        if(gp.kb.press4()){
            aliado = fisico;
        }
        if(gp.kb.press5()){
            aliado = matematico;
        }
        if(aliado != null){
            aliado.setOnScreen(true);
            aliado.paint(g);
            counter++;
            if(counter > 120){
                counter = 0;
                aliado.setOnScreen(false);
            }
        }
    }
}
