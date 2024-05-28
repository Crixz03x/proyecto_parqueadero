package co.edu.uniquindio.poo;

/**
 * Clase de tipo enumeración que agrupa los tipos de vehículo
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public enum TipoVehiculo {

    MOTO_HIBRIDA(0),
    CARRO(0),
    MOTO_CLASICA(0);

    private double tarifa;
    

    private TipoVehiculo(double tarifa){
        this.tarifa = tarifa;
    }

    /**
     * Método para verificar que si sea el administrador el que intenta cambiar la tarifa
     * @param tarifa valor de tarifa asignado a un tipo de vehículo
     * @param clase objeto que intenta cambiar la tarifa
     */

    public void verificar(double tarifa, Administrador clase){
        assert clase instanceof Administrador;
        setTarifa(tarifa);
    }

    /**
     * Método que cambia el valor de la tarifa para un tipo de vehículo
     * @param tarifa nuevo valor de la tarifa
     */

    private void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Método que obtiene la tarifa para un tipo de vehículo
     * @return La tarifa asociada a el tipo de vehículo
     */

    public double getTarifa() {
        return tarifa;
    }

}
