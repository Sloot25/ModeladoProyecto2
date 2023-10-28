package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import State.State;

public class Keyboard implements KeyListener{
    GamePanel gp;
    State state;
    Boolean up;
    Boolean down;
    Boolean right;
    Boolean left;

    public Keyboard(GamePanel gp){
        this.gp = gp;
        state = gp.getState();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            up = true;
        }
        if(key == KeyEvent.VK_DOWN){
            down = true;
        }
        if(key == KeyEvent.VK_LEFT){
            left = true;
        }
        if(key == KeyEvent.VK_RIGHT){
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            up = false;
        }
        if(key == KeyEvent.VK_DOWN){
            down = false;
        }
        if(key == KeyEvent.VK_LEFT){
            left = false;
        }
        if(key == KeyEvent.VK_RIGHT){
            right = false;
        }
    }
    
}
