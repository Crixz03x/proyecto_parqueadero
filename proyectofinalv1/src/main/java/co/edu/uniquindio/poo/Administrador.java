package co.edu.uniquindio.poo;

/**
 * Clase Administrador la cual hereda de la clase Persona
 * El administrador del parqueadero
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Administrador extends Persona{

    /**
    * Método constructor de la clase Administrador
    * @param nombre nombre del Administrador
    * @param cedula cédula del Administrador
    */
    public Administrador(String nombre,String cedula){
        super(nombre,cedula);
    }

    /**
     * Método para cambiar la tarifa de un determinado tipo de vehículo
     * @param vehiculo tipo de vehículo al cual se le modificará la tarifa
     * @param tarifa valor nuevo de la tarifa para el tipo de vehículo
     */

    public void cambiarTarifa(TipoVehiculo vehiculo, double tarifa){
        vehiculo.verificar(tarifa,this);
    }
}
