package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import res.Rutas.*;


public class GamePanel extends JPanel implements Runnable{
  Rutas rutas;

  public GamePanel(Rutas rutas){
    this.rutas = rutas;
    setPreferredSize(new Dimension(800,500));
    setBackground(Color.black);
    setDoubleBuffered(true);
    addKeyListener(kb);
    setFocusable(true);
  }

  public static void main(String[] args) {
    GamePanel gamePanel = new GamePanel(new Linux());

  }
}
