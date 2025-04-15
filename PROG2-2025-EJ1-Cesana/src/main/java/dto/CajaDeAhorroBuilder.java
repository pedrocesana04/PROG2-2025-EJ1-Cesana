package dto;

public class CajaDeAhorroBuilder implements ICuentaBuilder {
    private int Id;

    @Override
    public void setId (int id){
        this.Id = id;
    };

    public CajaDeAhorro build() {
        return new CajaDeAhorro(Id);
    }
}

