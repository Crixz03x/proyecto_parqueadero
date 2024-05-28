package co.edu.uniquindio.poo;

/**
 * Clase que agrupa los datos de un vehículo
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Vehiculo {
    private final String placa;
    private final String modelo;
    private final String velocidadMaxima;
    private final TipoVehiculo tipoVehiculo;
    private final Propietario propietario;

    /**
    * Método constructor de la clase vehículo
    */
    public Vehiculo(String placa, String modelo, String velocidadMaxima, TipoVehiculo tipoVehiculo,Propietario propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
    }

    /**
     * Método para obtener la placa del vehículo
     * @return placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }
    
    /**
     * Método para obtener el tipo de vehículo del vehículo
     * @return tipo de vehículo
     */
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Método para obtener el modelo del vehículo
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método para obtener el propietario del vehículo
     * @return propietario del vehículo
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Método para obtener la velocidad maxima del vehículo
     * @return velocidad maxima del vehículo
     */
    public String getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
    @Override
    public String toString() {
        return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", tipoVehiculo=" + tipoVehiculo + ", propietario="
                + propietario + "]";
    }
}
    
