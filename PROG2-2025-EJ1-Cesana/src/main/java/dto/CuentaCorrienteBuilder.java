package dto;

public class CuentaCorrienteBuilder implements ICuentaBuilder {
    private double Saldo;
    private int Id;

    @Override
    public void setSaldo(double saldo) {
        this.Saldo = saldo;
    }

    @Override
    public void setId(int id) {
        this.Id = id;
    }

    public CuentaCorriente build() {
        return new CuentaCorriente(Saldo, Id);
    }
}
