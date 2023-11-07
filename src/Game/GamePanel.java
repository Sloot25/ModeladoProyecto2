package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import Entity.Entity;
import Entity.Player;
import Item.Item;
import Item.Objeto;
import State.Dead;
import State.Menu;
import State.Pause;
import State.Play;
import State.State;

public class GamePanel extends JPanel implements Runnable{
    int screenWidth = 1000;
    int screenHeight = 560;
    int worldWidth = 2000;
    int worldHeight = 1120;
    int scale = 1;
    int fps = 60;
    public CollisionChecker cc = new CollisionChecker(this);
    public Keyboard kb = new Keyboard(this);
    public AssetSetter as = new AssetSetter(this);
    public SoundPlayer sp = new SoundPlayer();
    public LevelCreator lc = new LevelCreator(this);
    public UserInterface ui = new UserInterface(this);
    public Player player = new Player(this, kb);
    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Entity> npcs = new ArrayList<Entity>();
    public ArrayList<Entity> enemies = new ArrayList<Entity>();
    State estadoActual;
    State menu = new Menu();
    State dead = new Dead();
    State pause = new Pause();
    State play = new Play();
    Thread gameThread;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kb);
        this.setFocusable(true);
    }
    /*
     * Coloca las entidades y objetos en el mapa, así como preparar lo que sea necesario
     */
    public void setGame(){
        as.setNPCs();
        as.setEnemies();
        as.setItems();
    }
    /*
     * Inicia el hilo de ejecución
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    /*
     * Mientras se este ejecutando el juego, este metodo debera actualizar y repintar el juego
     */
    @Override
    public void run() {
        double interval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update();
                repaint();
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
    }
    /*
     * Actualiza la posición y sprites de las entidades y objetos del juego
     */
    public void update(){   
        player.update();
        for(Entity npc: npcs){
            npc.update();
        }
        for(Entity enemy: enemies){
            enemy.update();
        }
    }
    /*
     * Pinta el mapa, así como todos los objetos y entidades en el rango de la pantalla
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);

        lc.paint(g2);
        for(Entity npc: npcs){
            npc.paint(g2);
        }
        for(Entity enemy: enemies){
            enemy.paint(g2);
        }
        for(Item item: items){
            item.paint(g2);
        }
        player.paint(g2);
        ui.paint(g2);
        g2.dispose();
    }
    /*
     * Regresa el estado actual
     * @return State estadoActual
     */
    public State getState() {
        return estadoActual;
    }
    /*
     * Regresa la altura del mundo
     * @return int 
     */
    public int getWorldHeight() {
        return worldHeight;
    }
    /*
     * Regresa la altura de la pantalla, lo que puede ver el jugador
     * @return int 
     */
    public int getScreenHeight() {
        return screenHeight;
    }
    /*
     * Regresa el ancho del mundo
     * @return int
     */
    public int getWorldWidth() {
        return worldWidth;
    }
    /*
     * Regresa el ancho de la pantalla, lo que puede ver el jugador
     * @return int
     */
    public int getScreenWidth() {
        return screenWidth;
    }
    
}