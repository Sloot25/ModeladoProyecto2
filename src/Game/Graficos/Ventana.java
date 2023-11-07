package Game.Graficos; 

import java.awt.BorderLayout;
import java.awt.image.BufferedImage; 


import javax.swing.JFrame;
import javax.swing.ImageIcon;
public class Ventana extends JFrame {
  private String titulo; 
  private final ImageIcon icono; 

  public Ventana(final String titulo, final SuperficieDibujo sd){
    this.titulo = titulo; 
    //BufferedImage imagen = getRutas().getImagen("");
    //this.icono = new ImageIcon(imagen);
    configurarVentana(sd);
  }

  private void configurarVentana(final SuperficieDibujo sd){
    setTitle(titulo);
    //setIconImage(icono.getImagen());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new BorderLayout());
    add(sd, BorderLayout.CENTER);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
