package bastanteo.cloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {

    private Utilitario() {

    }

    public static Utilitario crearUtilitario() {
            return new Utilitario();
    }

    public  String obtenerFechaActual() {

            String fechaActualCadena = "";
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fechaActualCadena = formatoFecha.format(fechaActual);

            return fechaActualCadena;

    }

    public  Date convertirCadenaPorFecha(String fechaIngreso) {
            Date fecha = null;
            
            try {

                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    fecha = formatoFecha.parse(fechaIngreso);

            } catch (ParseException e) {

                    e.printStackTrace();
            }

            return fecha;

    }
    

    
    

}
