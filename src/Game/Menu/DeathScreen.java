package Game.Menu;

import javax.swing.JPanel;

import Game.Keyboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import res.Rutas.Rutas;
import State.Dead;
public class DeathScreen extends JPanel implements Runnable{
  private int screenWidth = 1000;
  private int screenHeight = 500;
  private Keyboard kb;
  private Dead dead;
  private Rutas rutas;
  private Thread gameThread;
  private final int FPS = 60;
  public DeathScreen(Rutas rutas, Dead dead){
    kb = new Keyboard();
    this.dead = dead;
    this.rutas = rutas;
    this.setPreferredSize(new Dimension(screenWidth,screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(kb);
    this.setFocusable(true);
  }
  public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
  }
  @Override
  public void run() {
    double interval = 1000000000/FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime; 
    long timer = 0; 
    
    while(gameThread != null){
      currentTime = System.nanoTime();
      delta += (currentTime -lastTime)/interval; 
      timer += (currentTime - lastTime);
      lastTime = currentTime; 
      if(delta >= 1){
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
    if(kb.pressEnter()){
      dead.menu();
    }
  }
  public void paint(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(rutas.getImagen("youdied.png"), 0, 0, screenWidth, screenHeight, null);
    g2.setFont(new Font("Impact", Font.PLAIN, 40));
    g2.setColor(Color.RED);
    g2.drawString("Press enter to go to menu", 400, 400);
  }
}