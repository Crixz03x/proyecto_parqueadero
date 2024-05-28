package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Clase que agrupa los datos de un parqueadero
 * 
 * @author Samuel Saith Calle Santa y Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Parqueadero {
    private Administrador administrador;
    private final Capacidad capacidad;
    private final Hashtable<Posicion,Vehiculo> puestos;
    private final Collection<RegistroVehiculo> registros;

    /**
     * Método constructor de la clase Parqueadero
     */

    public Parqueadero(Administrador administrador,Capacidad capacidad) {
        this.administrador = administrador;
        this.capacidad = capacidad;
        registros = new LinkedList<>();
        puestos = new Hashtable<Posicion,Vehiculo>();
    }

    /**
     * Método para obtener el administrador del parqueadero
     * 
     * @return administrador del parqueadero
     */

    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Método para obtener los puestos que tiene el parqueadero 
     * 
     * @return puestos del parqueadero
     */

    public Hashtable<Posicion, Vehiculo> getPuestos() {
        return puestos;
    }

    /**
     * Método para obtener la capacidad del parqueadero
     * 
     * @return capacidad del parqueadero
     */

    public Capacidad getCapacidad() {
        return capacidad;
    }

    /**
     * Método para obtener todos los registros que tenga el parqueadero
     * 
     * @return vehículos registrados en el sistema
     */

    public Collection<RegistroVehiculo> getRegistros() {
        return Collections.unmodifiableCollection(registros);
    }

    /**
     * Método que agrega el registro de un vehículo al parqueadero
     * @param registro el registro que se va a agregar al parqueadero
     */

    public void agregarRegistro(RegistroVehiculo registro){
        registros.add(registro);
    }

    /**
     * Método que cambia el administrador del parqueadero
     * @param administrador nuevo administrador del parqueadero
     */

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Método para parquear un vehículo en el parqueadero
     * 
     * @param posicion posición donde se va a guardar el vehículo
     * @param vehiculo vehículo a guardar
     * @param fecha fecha en la que se guardó un vehículo en un puesto
     */

    public void parquearVehiculo(Posicion posicion, Vehiculo vehiculo, LocalDateTime fecha){
        assert posicion.getI()<=capacidad.getFilas() && posicion.getI()>0;
        assert posicion.getJ()<=capacidad.getColumnas() && posicion.getJ()>0;
        assert !puestos.contains(vehiculo);
        puestos.putIfAbsent(posicion,vehiculo);
        agregarRegistro(new RegistroVehiculo(fecha, posicion, vehiculo));
    }

    /**
     * Método para sacar un vehiculo del parqueadero
     * 
     * @param posicion posición en la que se guardó un vehiculo
     * @param fecha fecha en la cual se entregara/sale un vehiculo
     */

    public void entregarVehiculo(Posicion posicion,LocalDateTime fecha){
        var registro = obtenerRegistroVehiculo(puestos.get(posicion));
        registro.setFechaSalida(fecha);
        puestos.remove(posicion);
    }

    /**
     * Método para obtener el registro de un vehiculo especifico
     * 
     * @param vehiculo El vehiculo del cual se quiere obtener su registro
     * @return El registro de ese vehiculo
     */

    public RegistroVehiculo obtenerRegistroVehiculo(Vehiculo vehiculo){
        Predicate<RegistroVehiculo> condicion = r->r.getVehiculo().equals(vehiculo);
        return getRegistros().stream().filter(condicion).findAny().get();
    }

    /**
     * Método para obtener las ganancias de un dia especifico.
     * 
     * @param fecha La fecha de la cual se quieren conocer las ganancias
     * @return Las ganancias de esa fecha
     */

    public double obtenerGananciasDelDia(LocalDate fecha){

        Predicate<RegistroVehiculo> condicion = r->r.getFechaSalida().getYear() == fecha.getYear() && r.getFechaSalida().getMonthValue() == fecha.getMonthValue() && r.getFechaSalida().getDayOfMonth() == fecha.getDayOfMonth();

        var gananciaDelDia = registros.stream().filter(condicion).mapToDouble(r->r.calcularPago()).sum();
        return gananciaDelDia;

    }

    /**
     * Método para obtener las ganancias del dia en el cual se invoco el método
     * @return Las ganancias del dia en el cual se invoco el método
     */

    public double obtenerGananciasDelDia(){
        var fecha = LocalDate.now();

        Predicate<RegistroVehiculo> condicion = r->r.getFechaSalida().getYear() == fecha.getYear() && r.getFechaSalida().getMonthValue() == fecha.getMonthValue() && r.getFechaSalida().getDayOfMonth() == fecha.getDayOfMonth();

        var gananciaDelDia = registros.stream().filter(condicion).mapToDouble(r->r.calcularPago()).sum();
        return gananciaDelDia;
    }


    /**
     * Método para obtener el propietario del vehiculo según la posición
     * @param puesto puesto en el que está ubicado el vehiculo
     * @return propietario del vehiculo
     */
    public Propietario obtenerPropietarioVehiculo(Posicion puesto){
        var vehiculo = getPuestos().get(puesto);
        var propietario = vehiculo.getPropietario();
        return propietario;
    }

    
 
}
