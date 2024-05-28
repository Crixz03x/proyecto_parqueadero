package co.edu.uniquindio.poo;

/**
 * Clase Posición (posición asociada a un puesto)
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Posicion {
    private final int i;
    private final int j;

    /**
     * Método constructor de la clase Posición
     */

    public Posicion(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * Método para obtener la fila de la posición
     * @return fila asociada a la posición
     */

    public int getI() {
        return i;
    }

    /**
     * Método para obtener la columna de la posición
     * @return columna asociada a la posición
     */

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "Posicion [i=" + i + ", j=" + j + "]";
    }

}
