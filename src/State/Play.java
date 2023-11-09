package State;

import res.Constantes;
public class Play implements State {
  private InterfazUsuario interfaz; 
  private boolean enFuncionamiento;
  private SuperficieDibujo sd; 
  private Ventana ventana; 

  public Play(InterfazUsuario interfaz){
    this.interfaz = interfaz;
  }
  public void inicializarEstado(){
    System.setProperty("sun.java2d.openg1", "True");

    this.iniciarJuego();
  }
  public void menu(){
    this.interfaz.setEstado(this.interfaz.getEstadoMenu());
  }
  public void jugar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPlay());
  }
  public void morir(){
    this.interfaz.setEstado(this.interfaz.getEstadoDead());
  }
  public void pausar(){
    this.interfaz.setEstado(this.interfaz.getEstadoPause());
  }

  private void iniciarJuego(){
    enFuncionamiento = true;
    inicializar();
    // Deberiamos inicializar la musica de igual forma aqui 
  }

  private void inicializar(){
    sd = new SuperficieDibujo(Constantes.ANCHO_PANTALLA, Constantes.ALTO_PANTALLA);
    ventana = new Ventana(titulo, sd);
    interfaz.cambiar(sd);
  }

  private void iniciarBuclePrincipal(){
    int actualizacionesAcumuladas = 0; 
    int frameAcumulados = 0;
  }
    
}
