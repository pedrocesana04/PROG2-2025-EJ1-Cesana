package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo {

    private double GiroDescubierto;
    private int Transacciones;

    public CuentaCorriente(double saldo, int id) {
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
        CalcularGiroDescubierto();
            if (GiroDescubierto + Saldo < monto) {
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

    private void CalcularGiroDescubierto() {
        this.GiroDescubierto = Saldo;
    }
}
