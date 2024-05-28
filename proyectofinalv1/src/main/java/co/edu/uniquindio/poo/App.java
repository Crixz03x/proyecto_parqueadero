package co.edu.uniquindio.poo;


import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        var fecha = LocalDateTime.now();
        var dia = fecha.getDayOfMonth();
        var mes = fecha.getMonthValue();
        var año = fecha.getYear();

        System.out.print("Dia:"+dia+"Mes:"+mes+"Año:"+año);

}
}
