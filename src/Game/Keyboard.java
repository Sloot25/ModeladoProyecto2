package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import State.State;

public class Keyboard implements KeyListener{
    GamePanel gp;
    State state;
    Boolean up = false;
    Boolean down = false;
    Boolean right = false;
    Boolean left = false;

    public Keyboard(GamePanel gp){
        this.gp = gp;
        state = gp.getEstado();
    }
    /*
     * Revisa si el jugador ha presionado una tecla
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
    /*
     * Revisa si el jugador esta presionando una tecla actualmente
     */
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
    /*
     * Revisa si el jugador ha soltado la tecla que estaba presionando
     */
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
    /*
     * Regresa si se esta presionando el boton de arriba
     * @return Boolean up
     */
    public Boolean pressUp(){
        return up;
    }
    /*
     * Regresa si se esta presionando el boton de abajo
     * @return Boolean down
     */
    public Boolean pressDown(){
        return down;
    }
    /*
     * Regresa si se esta presionando el boton de derecho
     * @return Boolean right
     */
    public Boolean pressRight(){
        return right;
    }
    /*
     * Regresa si se esta presionando el boton de izquierda
     * @return Boolean left
     */
    public Boolean pressLeft(){
        return left;
    }
    
}
