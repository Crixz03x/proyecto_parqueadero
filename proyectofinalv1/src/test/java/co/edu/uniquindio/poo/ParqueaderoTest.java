package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Parqueadero
 * 
 * @author Samuel Saith Calle Santa & Cristhian Daniel Saavedra
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 */

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());


    @Test
    public void posicionNoValida(){

        LOG.info("Iniciando prueba posicion Invalida");

        var capacidad = new Capacidad(5,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var posicion1 = new Posicion(1, 1);
        var posicion2 = new Posicion(1, 2);
        var posicion3 = new Posicion(2, 1);
        var posicion4 = new Posicion(2, 2);
        var posicion5 = new Posicion(3, 1);
        var posicion6 = new Posicion(3, 2);
        var posicion7 = new Posicion(4, 1);
        var posicion8 = new Posicion(4, 2);
        var posicion9 = new Posicion(5, 1);
        var posicion10 = new Posicion(5, 2);

        var propietario = new Propietario("Fulano", "63908289");
        var carro1 = new Vehiculo("AWK171","Audi","25000",TipoVehiculo.CARRO,propietario);
        var carro2 = new Vehiculo("AWK172","Camaro","25000",TipoVehiculo.CARRO,propietario);
        var carro3 = new Vehiculo("AWK173","Mustang","25000",TipoVehiculo.CARRO,propietario);
        var carro4 = new Vehiculo("AWK174","Ferrari","25000",TipoVehiculo.CARRO,propietario);
        var carro5 = new Vehiculo("AWK175","Maserati","25000",TipoVehiculo.CARRO,propietario);

        var moto1 = new Vehiculo("BDC45441","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto2 = new Vehiculo("BDC45442","DT","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto3 = new Vehiculo("BDC45443","AKT","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto4 = new Vehiculo("BDC45444","Harvey","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto5 = new Vehiculo("BDC45445","Honda","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        
        parqueadero.parquearVehiculo(posicion1, carro1, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion2, carro2, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion3, carro3, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion4, carro4, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion5, carro5, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion6, moto1, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion7, moto2, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion8, moto3, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion9, moto4, LocalDateTime.now());
        parqueadero.parquearVehiculo(posicion10, moto5, LocalDateTime.now());

        assertTrue(parqueadero.getPuestos().containsValue(carro1));
        assertTrue(parqueadero.getPuestos().containsValue(carro2));
        assertTrue(parqueadero.getPuestos().containsValue(carro3));
        assertTrue(parqueadero.getPuestos().containsValue(carro4));
        assertTrue(parqueadero.getPuestos().containsValue(carro5));
        assertTrue(parqueadero.getPuestos().containsValue(moto1));
        assertTrue(parqueadero.getPuestos().containsValue(moto2));
        assertTrue(parqueadero.getPuestos().containsValue(moto3));
        assertTrue(parqueadero.getPuestos().containsValue(moto4));
        assertTrue(parqueadero.getPuestos().containsValue(moto5));

        var posicionInvalida = new Posicion(2,5);
        var miVehiculo = new Vehiculo("aaaaaaa","si","25000",TipoVehiculo.CARRO,propietario);
        assertThrows(Throwable.class, ()->parqueadero.parquearVehiculo(posicionInvalida,miVehiculo,LocalDateTime.now()));

        LOG.info("Finalizando prueba posicion Invalida");
    }

        @Test 
        public void parquearVehiculo(){

        LOG.info("Iniciando prueba parquear vehiculo");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var b = new Posicion(1, 2);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        var moto = new Vehiculo("BDC45444","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        parqueadero.parquearVehiculo(a, carro,LocalDateTime.now());
        parqueadero.parquearVehiculo(b, moto,LocalDateTime.now());
        assertEquals(parqueadero.getPuestos().get(a),carro);
        assertEquals(parqueadero.getPuestos().get(b),moto);

        LOG.info("Finalizando prueba parquear vehiculo");
    }

    @Test
    public void parquearOcupado(){

        LOG.info("Iniciando prueba parquear ocupado");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        var moto = new Vehiculo("BDC45444","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        parqueadero.parquearVehiculo(a, carro,LocalDateTime.now());
        parqueadero.parquearVehiculo(a, moto,LocalDateTime.now());
        assertTrue(parqueadero.getPuestos().get(a).equals(carro));
        assertFalse(parqueadero.getPuestos().get(a).equals(moto));
        
        LOG.info("Iniciando prueba parquear ocupado");
    }

    @Test
    public void parquearVehiculoEnMasDeUnLugar(){

        LOG.info("Iniciando prueba parquear vehiculo en mas de un lugar");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var b = new Posicion(2,3);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        parqueadero.parquearVehiculo(a, carro,LocalDateTime.now());
        assertThrows(Throwable.class,()->parqueadero.parquearVehiculo(b, carro,LocalDateTime.now()));
        assertTrue(parqueadero.getPuestos().get(a).equals(carro));

        LOG.info("Finalizando prueba parquear vehiculo en mas de un lugar");
    }

    @Test
    public void entregarVehiculo(){

        LOG.info("Iniciando prueba entregar vehiculo");

        var capacidad = new Capacidad(7,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var propietario = new Propietario("Fulano", "63908289");
        var carro = new Vehiculo("AWK173","Audi","25000",TipoVehiculo.CARRO,propietario);
        parqueadero.parquearVehiculo(a, carro,LocalDateTime.now());
        parqueadero.entregarVehiculo(a, LocalDateTime.now().plusDays(1));
        assertFalse(parqueadero.getPuestos().containsKey(a));

        LOG.info("Finalizando prueba entregar vehiculo");

}

    @Test
    public void dineroRecaudado(){

        LOG.info("Iniciando prueba dinero Recaudado");

        var capacidad = new Capacidad(2,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var b = new Posicion(1, 2);
        var c = new Posicion(2, 1);
        var d = new Posicion(2, 2);
 
        administrador.cambiarTarifa(TipoVehiculo.MOTO_CLASICA, 2000);
        administrador.cambiarTarifa(TipoVehiculo.CARRO, 5000);

        var propietario = new Propietario("Fulano", "63908289");
        var carro1 = new Vehiculo("AWK171","Audi","25000",TipoVehiculo.CARRO,propietario);
        var carro2 = new Vehiculo("AWK172","Camaro","25000",TipoVehiculo.CARRO,propietario);
        var moto1 = new Vehiculo("BDC45441","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto2 = new Vehiculo("BDC45442","DT","25000",TipoVehiculo.MOTO_CLASICA,propietario);

        parqueadero.parquearVehiculo(a, carro1, LocalDateTime.of(2024,5,27,10,0,0));
        parqueadero.parquearVehiculo(b, carro2, LocalDateTime.of(2024,5,27,12,0,0));
        parqueadero.parquearVehiculo(c, moto1, LocalDateTime.of(2024,5,27,1,0,0));
        parqueadero.parquearVehiculo(d, moto2, LocalDateTime.of(2024,5,27,5,0,0));

        parqueadero.entregarVehiculo(a, LocalDateTime.of(2024,5,28,10,0,0));
        parqueadero.entregarVehiculo(b, LocalDateTime.of(2024,5,28,12,0,0));
        parqueadero.entregarVehiculo(c, LocalDateTime.of(2024,5,28,1,0,0));
        parqueadero.entregarVehiculo(d, LocalDateTime.of(2024,5,28,5,0,0));

        var registroCarro1 = parqueadero.obtenerRegistroVehiculo(carro1);
        var registroCarro2 = parqueadero.obtenerRegistroVehiculo(carro2);
        var registroMoto1 = parqueadero.obtenerRegistroVehiculo(moto1);
        var registroMoto2 = parqueadero.obtenerRegistroVehiculo(moto2);

        assertEquals(registroCarro1.calcularPago(),120000);
        assertEquals(registroCarro2.calcularPago(),120000);
        assertEquals(registroMoto1.calcularPago(),48000);
        assertEquals(registroMoto2.calcularPago(),48000);

        var ganancia = parqueadero.obtenerGananciasDelDia(LocalDate.of(2024,5,28));

        assertEquals(ganancia,336000);

        LOG.info("Finalizando prueba dinero Recaudado");


    }

    @Test
    public void dineroRecaudado2(){
        var capacidad = new Capacidad(2,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var b = new Posicion(1, 2);
        var c = new Posicion(2, 1);
        var d = new Posicion(2, 2);

        administrador.cambiarTarifa(TipoVehiculo.MOTO_CLASICA, 2000);
        administrador.cambiarTarifa(TipoVehiculo.CARRO, 5000);

        var propietario = new Propietario("Fulano", "63908289");
        var carro1 = new Vehiculo("AWK171","Audi","25000",TipoVehiculo.CARRO,propietario);
        var carro2 = new Vehiculo("AWK172","Camaro","25000",TipoVehiculo.CARRO,propietario);
        var moto1 = new Vehiculo("BDC45441","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario);
        var moto2 = new Vehiculo("BDC45442","DT","25000",TipoVehiculo.MOTO_CLASICA,propietario);

        parqueadero.parquearVehiculo(a, carro1, LocalDateTime.now());
        parqueadero.parquearVehiculo(b, carro2, LocalDateTime.now());
        parqueadero.parquearVehiculo(c, moto1, LocalDateTime.now());
        parqueadero.parquearVehiculo(d, moto2, LocalDateTime.now());

        parqueadero.entregarVehiculo(a, LocalDateTime.now().plusHours(2));
        parqueadero.entregarVehiculo(b, LocalDateTime.now().plusHours(2));
        parqueadero.entregarVehiculo(c, LocalDateTime.now().plusHours(2));
        parqueadero.entregarVehiculo(d, LocalDateTime.now().plusHours(2));

        var registroCarro1 = parqueadero.obtenerRegistroVehiculo(carro1);
        var registroCarro2 = parqueadero.obtenerRegistroVehiculo(carro2);
        var registroMoto1 = parqueadero.obtenerRegistroVehiculo(moto1);
        var registroMoto2 = parqueadero.obtenerRegistroVehiculo(moto2);

        assertEquals(registroCarro1.calcularPago(),10000);
        assertEquals(registroCarro2.calcularPago(),10000);
        assertEquals(registroMoto1.calcularPago(),4000);
        assertEquals(registroMoto2.calcularPago(),4000);

        var ganancia = parqueadero.obtenerGananciasDelDia();

        assertEquals(ganancia,28000);


    }

    @Test
    public void obtenerPropietarioSegunElPuesto(){

        LOG.info("Iniciando prueba obtener propietario");

        var capacidad = new Capacidad(2,2);
        var administrador = new Administrador("juan","246060089");
        var parqueadero = new Parqueadero(administrador,capacidad);
        var a = new Posicion(1, 1);
        var b = new Posicion(1, 2);
        var c = new Posicion(2, 1);
        var d = new Posicion(2, 2);

        administrador.cambiarTarifa(TipoVehiculo.MOTO_CLASICA, 2000);
        administrador.cambiarTarifa(TipoVehiculo.CARRO, 5000);

        var propietario1 = new Propietario("Luis", "63908281");
        var propietario2 = new Propietario("Fernando", "63908282");
        var propietario3 = new Propietario("Carlos", "63908283");
        var propietario4 = new Propietario("David", "63908285");
        var carro1 = new Vehiculo("AWK171","Audi","25000",TipoVehiculo.CARRO,propietario1);
        var carro2 = new Vehiculo("AWK172","Camaro","25000",TipoVehiculo.CARRO,propietario2);
        var moto1 = new Vehiculo("BDC45441","suzuki","25000",TipoVehiculo.MOTO_CLASICA,propietario3);
        var moto2 = new Vehiculo("BDC45442","DT","25000",TipoVehiculo.MOTO_CLASICA,propietario4);

        parqueadero.parquearVehiculo(a, carro1, LocalDateTime.now());
        parqueadero.parquearVehiculo(b, carro2, LocalDateTime.now());
        parqueadero.parquearVehiculo(c, moto1, LocalDateTime.now());
        parqueadero.parquearVehiculo(d, moto2, LocalDateTime.now());

        assertEquals(parqueadero.obtenerPropietarioVehiculo(a),propietario1);
        assertEquals(parqueadero.obtenerPropietarioVehiculo(b),propietario2);
        assertEquals(parqueadero.obtenerPropietarioVehiculo(c),propietario3);
        assertEquals(parqueadero.obtenerPropietarioVehiculo(d),propietario4);

        LOG.info("Finalizando prueba obtener propietario");
        
    }
}
