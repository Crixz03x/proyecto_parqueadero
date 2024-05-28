package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase RegistroVehiculo
 * 
 * @author Samuel Saith Calle Santa & Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 */

public class RegistroVehiculoTest {
    private static final Logger LOG = Logger.getLogger(RegistroVehiculoTest.class.getName());


    @Test
    public void registroVehiculoExitoso(){

        LOG.info("Iniciando prueba registro vehiculo");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        var fechaEntrada = LocalDateTime.now();
        var fechaSalida = LocalDateTime.now().plusDays(1);
        parqueadero.parquearVehiculo(a, carro,fechaEntrada);
        parqueadero.entregarVehiculo(a, fechaSalida);
        var registroCarro = parqueadero.obtenerRegistroVehiculo(carro);
        assertEquals(registroCarro.getFechaEntrada(),fechaEntrada);
        assertEquals(registroCarro.getFechaSalida(),fechaSalida);
        assertEquals(registroCarro.getPosicion(),a);
        assertEquals(registroCarro.getVehiculo(), carro);

        LOG.info("Finalizando prueba registro vehiculo");
}

@Test

    public void calcularPagoVehiculo(){

        LOG.info("Iniciando prueba calcular pago vehiculo");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        var fechaEntrada = LocalDateTime.of(2024,5,27,10,0,0);
        var fechaSalida = LocalDateTime.of(2024,5,28,11,30,0);
        parqueadero.parquearVehiculo(a, carro,fechaEntrada);
        parqueadero.entregarVehiculo(a, fechaSalida);
        administrador.cambiarTarifa(TipoVehiculo.CARRO, 5000);
        var registroCarro = parqueadero.obtenerRegistroVehiculo(carro);
        assertEquals(registroCarro.calcularPago(),130000);

        LOG.info("Finalizando prueba calcular pago vehiculo");
    }
}
