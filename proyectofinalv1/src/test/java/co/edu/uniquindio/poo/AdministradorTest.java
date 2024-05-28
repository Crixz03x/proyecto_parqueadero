package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Administrador
 * 
 * @author Samuel Saith Calle Santa & Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 */

public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());

    @Test
    public void cambiarTarifa(){

        LOG.info("Iniciando prueba cambiar tarifa");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        parqueadero.setAdministrador(administrador);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        var moto = new Vehiculo("BDC45444","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        administrador.cambiarTarifa(TipoVehiculo.CARRO, 26000.5);
        administrador.cambiarTarifa(TipoVehiculo.MOTO_CLASICA, 160000);
        assertEquals(carro.getTipoVehiculo().getTarifa(), 26000.5);
        assertEquals(moto.getTipoVehiculo().getTarifa(), 160000);   
    }
}
