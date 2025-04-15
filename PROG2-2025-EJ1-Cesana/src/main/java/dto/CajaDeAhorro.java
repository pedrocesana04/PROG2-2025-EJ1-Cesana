package dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    private int Transacciones;

    public CajaDeAhorro(double saldo) {
        super();
        Transacciones = 0;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        Saldo += monto;
        Transacciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (Saldo < monto) {
            Saldo -= monto;
            Transacciones++;
            return true;
        }
        return false;
    }
    @Override
    public double getSaldo() {
        return Saldo;
    }

    @Override
    public int getOperaciones() {
        return Transacciones;
    }
}
