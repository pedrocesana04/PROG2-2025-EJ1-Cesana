package org.Banco.dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {

    private final double giroDescubierto;

    private CuentaCorriente(Builder builder) {
        this.Saldo = builder.initialSaldo;
        this.giroDescubierto = builder.giroDescubierto;
        this.Transacciones = 0;
    }

    public static class Builder {
        private double initialSaldo = 0;
        private double giroDescubierto = 0;

        public Builder withInitialSaldo(double initialSaldo) {
            this.initialSaldo = initialSaldo;
            return this;
        }

        public Builder withGiroDescubierto(double giroDescubierto) {
            this.giroDescubierto = giroDescubierto;
            return this;
        }

        public CuentaCorriente build() {
            return new CuentaCorriente(this);
        }
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <= 0) return false;
        Saldo += monto;
        Transacciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if(monto<= 0) return false;
        if ((Saldo - monto) < -giroDescubierto) return false;
        Saldo -= monto;
        Transacciones++;
        return true;
    }
}
