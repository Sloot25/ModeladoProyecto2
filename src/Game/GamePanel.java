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
import State.Dead;
import State.Menu;
import State.Pause;
import State.Play;
import State.State;

public class GamePanel extends JPanel implements Runnable{
    int screenWidth = 800;
    int screenHeight = 500;
    int worldWidth = 2000;
    int worldHeight = 800;
    int scale = 1;
    int fps = 60;
    public CollisionChecker cc = new CollisionChecker(this);
    public Keyboard kb = new Keyboard(this);
    public AssetSetter as = new AssetSetter();
    public SoundPlayer sp = new SoundPlayer();
    public LevelCreator lc = new LevelCreator();
    public UserInterface ui = new UserInterface();
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

    public void setGame(){
        as.setNPCs();
        as.setEnemies();
        as.setItems();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

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
    public void update(){   
        player.update();
        for(Entity npc: npcs){
            npc.update();
        }
        for(Entity enemy: enemies){
            enemy.update();
        }
    }

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

    public State getState() {
        return estadoActual;
    }
    public int getWorldHeight() {
        return worldHeight;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getWorldWidth() {
        return worldWidth;
    }
    public int getScreenWidth() {
        return screenWidth;
    }
    
}