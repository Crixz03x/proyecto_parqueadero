package co.edu.uniquindio.poo;


import java.time.LocalDateTime;

/**
 * Clase RegistroVehiculo 
 * el registro de un vehículo que haya parqueado en el parqueadero.
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class RegistroVehiculo {
    private final LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private final Posicion posicion;
    private final Vehiculo vehiculo;
    
    /**
     * Método constructor de la clase RegistroVehiculo
     */

    public RegistroVehiculo(LocalDateTime fechaEntrada, Posicion posicion, Vehiculo vehiculo) {
        this.fechaEntrada = fechaEntrada;
        this.posicion = posicion;
        this.vehiculo = vehiculo;
    }

    /**
     * Método que obtiene la fecha de entrada del vehículo
     * @return fecha de entrada del vehículo 
     */

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Método que obtiene la fecha de salida del vehículo
     * 
     * @return fecha de salida del vehículo 
     */

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Método que obtiene la posición en la que se guardó un vehículo
     * @return posición del parqueadero donde se guardo el vehículo
     */

    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Método que obtiene el vehículo registrado
     * @return vehículo asociado al registro
     */

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método para registrar la fecha de salida de un vehiculo
     * @param fechaSalida la fecha en la cual el vehiculo salio del parqueadero
     */

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Método para calcular el pago de un vehiculo registrado en el parqueadero
     * @return valor a pagar del vehiculo
     */

    public double calcularPago(){
        var tarifa = vehiculo.getTipoVehiculo().getTarifa();
        var pago = tarifa;
        var horasDeUso = obtenerHorasEntre(fechaEntrada, fechaSalida);
        if (horasDeUso > 0){
             pago = tarifa*horasDeUso;
        }
        return pago;
    }

    /**
     * Método para obtener las horas que transcurrieron entre dos fechas
     * @param fecha1
     * @param fecha2
     * @return
     */

    private int obtenerHorasEntre(LocalDateTime fecha1,LocalDateTime fecha2){
        assert fecha2.isAfter(fecha1);
        final var HORAS_DEL_DIA = 24;
        var horas = 0;
        var dias = 0;
        if (fecha2.getDayOfMonth() != fecha1.getDayOfMonth()){
             dias = fecha2.compareTo(fecha1);
        }
        horas = ((dias*HORAS_DEL_DIA) - fecha1.getHour()) + fecha2.getHour();

        
         if(fecha2.getMinute()>0 && fecha2.getMinute()!=fecha1.getMinute()){
            horas = horas + 1;
        }
         
        return horas;
        
    }

    @Override
    public String toString() {
        return "RegistroVehiculo [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", posicion="
                + posicion + ", vehiculo=" + vehiculo + "]";
    }

    

    


    
}
