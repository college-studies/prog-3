package trabalho;

public class PessoaFisica extends Cliente{
    private String nome;
    private String CPF;

    // constructor
    public PessoaFisica(String nome, String CPF, String telefone, String endereco, int clienteID, double divida) {
        super(telefone, endereco, clienteID, divida);
        this.nome = nome;
        this.CPF = CPF;
    }

    // setters
    public void setNome(String nome) { this.nome = nome; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    // getters
    public String getNome() { return this.nome; }
    public String getCPF() { return this.CPF; }
}

