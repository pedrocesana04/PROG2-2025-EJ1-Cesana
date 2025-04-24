package org.Banco.dto;

public abstract class Cuenta {
    protected double Saldo;
    protected int Transacciones;

    public abstract boolean agregarSaldo(double monto);
    public abstract boolean quitarSaldo(double monto);

    public synchronized double getSaldo() {
        return Saldo;
    }

    public synchronized int getOperaciones() {
        return Transacciones;
    }
}
