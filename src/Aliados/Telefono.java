package Aliados;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Entity.Enemy;
import Entity.Player;
import Game.GamePanel;
import Game.Keyboard;

public class Telefono {
    Keyboard kb;
    GamePanel gp;
    Player player;
    Aliado aliado;
    Actuario actuario;
    Biologo biologo;
    Computologo computologo;
    Fisico fisico;
    Matematico matematico;
    Random random;
    boolean summon;
    int counter = 0;
    int num = -1;

    public Telefono(GamePanel gp, Player player, Keyboard kb) {
        random = new Random();
        this.gp = gp;
        this.player = player;
        this.kb = kb;
        summon = false;
        setPhone();
        num = random.nextInt(5);
    }

    public void setPhone() {
        actuario = new Actuario(gp, player);
        biologo = new Biologo(gp, player);
        computologo = new Computologo(gp, player);
        fisico = new Fisico(gp, player);
        matematico = new Matematico(gp, player);
    }

    public void update(){
        if(aliado!=null){
            aliado.update();
            Enemy e = gp.cc.checkAliado(aliado);
            if(e != null){
                System.out.println("AAAAAAA");
            }
        }
    }

    public void paint(Graphics g) {
        Random random = new Random();
        aliado = null;
        if (kb.press1()) {
            summon = true;
        }
        if (summon) {
            switch (num) {
                case 0:
                    aliado = new Actuario(gp, player);
                    break;
                case 1:
                    aliado = new Biologo(gp, player);
                    break;
                case 2:
                    aliado = new Computologo(gp, player);
                    break;
                case 3:
                    aliado = new Fisico(gp, player);
                    break;
                case 4:
                    aliado = new Matematico(gp, player);
                    break;
            }
            if (aliado != null) {
                aliado.setOnScreen(true);
                aliado.paint(g);
                counter++;
                if (counter > 120) {
                    counter = 0;
                    aliado.setOnScreen(false);
                    summon = false;
                    num = random.nextInt(5);
                }
            }
        }
    }
    public boolean isSummoning(){
        return summon;
    }
}
