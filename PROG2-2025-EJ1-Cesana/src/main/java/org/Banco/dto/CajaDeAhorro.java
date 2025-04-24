package org.Banco.dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    private CajaDeAhorro(Builder builder){
        this.Saldo = builder.initialSaldo;
        this.Transacciones = 0;
    }

    public static class Builder{
        private double initialSaldo = 0;

        public Builder withInitialSaldo(double initialSaldo) {
            this.initialSaldo = initialSaldo;
            return this;
        }

        public CajaDeAhorro build() {
            return new CajaDeAhorro(this);
        }
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if(monto<=0) return false;
        Saldo += monto;
        Transacciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (Saldo > monto || monto <= 0) return false;
        Saldo -= monto;
        Transacciones++;
        return true;
    }
}
