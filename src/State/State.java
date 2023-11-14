package State;

public interface State {
  /*
   * Cambia el estado actual a menu
   */
  public void menu();
  /*
   * Cambia el estado actual al juego
   */
  public void jugar();
  /*
   * Cambia el estado actual a pausa
   */
  public void pausar();
  /*
   * Cambia el estado actual a muerte 
   */
  public void morir();
  /*
   * Cambia el estado actual a ganador
   */
  public void ganar();
  /*
   * Inicializa el estado
   */
  public void inicializar();
}
