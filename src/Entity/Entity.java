package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity{
    /*
     * Actualiza la información de la entidad
     */
    public void update();
    /*
     * Pinta a la entidad en pantalla
     * @param Graphics g
     */
    public void paint(Graphics g);
    /*
     * Regresa la caja de colisiones
     */
    public Rectangle getBox();
    /*
     * Regresa la posicion en x
     */
    public int getX();
    /*
     * Regresa la posicion en y
     */
    public int getY();
    /*
     * Modifica la posicion x
     */
    public void setY(int i);
    /*
     * Modifica la posicion y
     */
    public void setX(int i);
    /*
     * Regresa la direccion a la que se mueve la entidad
     */
    public String getDirection();
    /*
     * Modifica la direccion de la entidad
     */
    public void setDirection(String direction);
    /*
     * Modifica si hay colisiones 
     */
    public void setCollision(boolean b);
    /*
     * Regresa si hay colisiones
     */
    public boolean getCollision();
    /*
     * Regresa la imagen de la entidad
     */
    public void getEntityImage();
    /*
     * Regresa la parte superior de la caja de colisiones
     */
    public Rectangle getBoxUp();
    /*
     * Regresa la izquierda de la caja de colisiones
     */
    public Rectangle getBoxDown();
    /*
     * Regresa la derecha de la caja de colisiones
     */
    public Rectangle getBoxLeft();
    /*
     * Modifica la velocidad X
     */
    public Rectangle getBoxRight();
    /*
     * Modifica la velocidad de x
     */
    public void setSpeedX(double d);
    /*
     * Regresa la velocidad de x
     */
    public double getSpeedX();
    /*
     * Modifica la velocidad de y
     */
    public void setSpeedY(double d);
    /*
     * Regresa la velocidad de y
     */
    public double getSpeedY();
    /*
     * Modifica el valor de la gravedad
     */
    public void setGravity(double d);
    /*
     * Regresa el valor de la gravedad
     */
    public double getGravity();
    /*
     * Modifica si una entidad esta en el suelo
     */
    public void setOnFloor(boolean b);
    /*
     * Coloca a una entidad en el suelo
     */
    public boolean isOnFloor();
}
