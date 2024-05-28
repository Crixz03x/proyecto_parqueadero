package co.edu.uniquindio.poo;

/**
 * Clase Persona
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public abstract class Persona {
    private final String nombre;
    private final String cedula;
    
    /**
     * Método constructor de la clase Persona
     */
    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    /**
     * Método para obtener el nombre de una persona
     * 
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la cédula de una persona
     * @return cédula de la persona
     */

    public String getCedula() {
        return cedula;
    }
}
