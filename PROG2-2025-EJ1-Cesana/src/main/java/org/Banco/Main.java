package org.Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.Banco.service.LogicaCuenta;
import org.Banco.dto.CuentaCorriente;
import org.Banco.dto.CajaDeAhorro;
import org.Banco.dto.Cuenta;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Cuenta> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (rand.nextBoolean()) {
                lista.add(
                        new CajaDeAhorro.Builder()
                                .withInitialSaldo(rand.nextDouble() * 1000)
                                .build()
                );
            } else {
                lista.add(
                        new CuentaCorriente.Builder()
                                .withInitialSaldo(rand.nextDouble() * 1000)
                                .withGiroDescubierto(500)
                                .build()
                );
            }
        }

        LogicaCuenta.getInstance().setCuentas(lista);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                int idx = rand.nextInt(10);
                double monto = rand.nextDouble() * 100;
                if (rand.nextBoolean()) {
                    LogicaCuenta.getInstance().agregarSaldo(idx, monto);
                } else {
                    LogicaCuenta.getInstance().quitarSaldo(idx, monto);
                }
            });
        }

        executor.shutdown();
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace(); // o manejo adecuado
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Cuenta " + i +
                    ": Saldo=" + LogicaCuenta.getInstance().consultarSaldo(i) +
                    ", Operaciones=" + LogicaCuenta.getInstance().consultarOperaciones(i));
        }
    }
}