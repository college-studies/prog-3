package trabalho;

public abstract class Cliente {
    private String telefone;
    private String endereco;
    private int clienteID;
    private double divida;

    // constructor
    public Cliente(String telefone, String endereco, int clienteID, double divida) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.clienteID = clienteID;
        this.divida = divida;
    }

    // setters
    public void setTelefone(String telefone) { this.telefone = telefone;}
    public void setEndereco(String endereco) { this.endereco = endereco;}
    public void setDivida(double divida) { this.divida = divida;}

    // getters
    public String getTelefone() { return this.telefone; }
    public String getEndereco() { return this.endereco; }
    public double getDivida() { return this.divida; }
    public int getClienteID() { return this.clienteID; }

}

