package dto;

public abstract class Cuenta {
    protected double Saldo;
    protected int Id;

    public Cuenta() {
        this.Saldo = 0;
    }

    public int getId() {
        return Id;
    }
}
