package Game.Menu;

import javax.swing.JPanel;

import Game.Keyboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Font;

import res.Rutas.Rutas;
import State.Menu;
public class Creditos extends JPanel implements Runnable{
  private int screenWidth = 1000;
  private int screenHeight = 500;
  private Menu menu;
  private Rutas rutas;
  private Keyboard kb;
  private final int FPS = 60;
  private Thread gameThread;
  public Creditos(Rutas rutas, Menu menu){
    kb = new Keyboard();
    this.menu = menu;
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
  public void run(){
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
        menu.menuInicio();
    }
    
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.black);
    g2.drawImage(rutas.getImagen("cucaracha-bailando.png"), 0, 0, screenWidth, screenHeight, null);
    g2.setFont(new Font("Impact", Font.BOLD, 30 ));    
    g2.setColor(Color.BLACK);
    int x = 100;
    int y = 100;
    g2.drawString("CREDITOS",x,y);
    y += 50;
    g2.drawString("Martínez Cano Ricardo Iván", x, y);
    y += 50;
    g2.drawString("Méndez Razo Carlos Geovanni", x, y);
    y += 50;
    g2.drawString("Vidal Aguilar Diego Jesus", x, y);
    y += 50;
    g2.drawString("> Regresar", 800, y);
    g2.dispose();
  }
}
