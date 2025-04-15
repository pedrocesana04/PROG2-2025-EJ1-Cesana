import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dto.CuentaCorrienteBuilder;
import service.LogicaCuenta;
import dto.CajaDeAhorroBuilder;
import dto.CuentaCorriente;
import dto.CajaDeAhorro;

public class Main {
    public static void main(String[] args){
        Random random = new Random();
        LogicaCuenta logica = new LogicaCuenta();
        CuentaCorrienteBuilder cuentaCorrienteBuilder = new CuentaCorrienteBuilder();
        CajaDeAhorroBuilder cajaDeAhorroBuilder = new CajaDeAhorroBuilder();
        for(int i = 0; i<10; i++){
            int tipo = random.nextInt(2);
            if(tipo==0){
                cuentaCorrienteBuilder.setId(i+1);
                CuentaCorriente cuentaCorriente = cuentaCorrienteBuilder.build();
                logica.agregarCuenta(cuentaCorriente);
            }
            else {
                cajaDeAhorroBuilder.setId(i+1);
                CajaDeAhorro cajaDeAhorro = cajaDeAhorroBuilder.build();
                logica.agregarCuenta(cajaDeAhorro);
            }
        }

        ExecutorService executor= Executors.newFixedThreadPool(5);
        List<Future<Resultado>> futures = new ArrayList<Future<Resultado>>();
        long start= System.currentTimeMillis();
    }
}
