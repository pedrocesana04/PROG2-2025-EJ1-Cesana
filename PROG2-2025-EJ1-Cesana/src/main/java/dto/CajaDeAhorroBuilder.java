package dto;

public class CajaDeAhorroBuilder implements ICuentaBuilder {
    private double Saldo;
    private int Id;

    @Override
    public void setSaldo (double saldo){
        this.Saldo = Saldo;
    };

    @Override
    public void setId (int id){
        this.Id = id;
    };

    public CuentaCorriente build() {
        return new CuentaCorriente(Saldo, Id);
    }
}

