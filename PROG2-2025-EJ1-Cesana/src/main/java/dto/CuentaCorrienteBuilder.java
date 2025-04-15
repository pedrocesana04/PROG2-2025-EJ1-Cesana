package dto;

public class CuentaCorrienteBuilder implements ICuentaBuilder {
    private int Id;

    @Override
    public void setId(int id) {
        this.Id = id;
    }

    public CuentaCorriente build() {
        return new CuentaCorriente(Id);
    }
}
