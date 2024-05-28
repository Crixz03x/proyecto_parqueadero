package co.edu.uniquindio.poo;

 /**
 * Clase Capacidad, indica la capacidad maxima de almacenamiento en un parqueadero
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Capacidad {  
    private final int filas;
    private final int columnas;
    
    /**
     * Método constructor de la clase Capacidad
     */
    public Capacidad(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    /**
     * Método para obtener el número de filas
     * @return número de filas
     */
    public int getFilas() {
        return filas;
    }
    /**
     * Método para obtener el número de columnas
     * @return número de columnas
     */
    public int getColumnas() {
        return columnas;
    }
    
}
