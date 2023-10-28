package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import Entity.Enemy;
import Entity.NPC;
import Entity.Player;
import Item.Item;
import State.Dead;
import State.Menu;
import State.Pause;
import State.Play;
import State.State;

public class GamePanel extends JPanel implements Runnable{
    int width = 800;
    int height = 500;
    int scale = 1;
    int fps = 60;
    Player player = new Player();
    CollisionChecker cc = new CollisionChecker();
    Keyboard kh = new Keyboard(this);
    AssetSetter as = new AssetSetter();
    SoundPlayer sp = new SoundPlayer();
    LevelCreator lc = new LevelCreator();
    UserInterface ui = new UserInterface();
    ArrayList<Item> objetos = new ArrayList<Item>();
    ArrayList<NPC> npcs = new ArrayList<NPC>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    State estadoActual;
    State menu = new Menu();
    State dead = new Dead();
    State pause = new Pause();
    State play = new Play();
    Thread gameThread;


    public GamePanel(){
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void setGame(){
        as.setNPCs();
        as.setEnemies();
        as.setItems();
        estadoActual = menu;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta>=1){
                update(null);
                repaint();
                delta--;
            }
            if(timer >= 1000000000){
                timer = 0;
            }
        }
    }
    public void update(){   
    }

    public State getState() {
        return estadoActual;
    }
}