package Aliados;

import java.awt.Graphics2D;

import Entity.Player;

public class Actuario implements Aliado{
  private Player player; 
  public Actuario(Player player){
    this.player = player;
  }
  public void set(){}
  public void update(){}
  public void attack(){}
  public void paint(Graphics2D g2){}
}
