package trabalho;

public class PessoaJuridica extends Cliente {
    private String razaoSocial;
    private String CNPJ;
    private String nomeFantasia;

    // constructor
    public PessoaJuridica( String razaoSocial, String CNPJ, String nomeFantasia, String telefone, String endereco, int clienteID, double divida) {
        super(telefone, endereco, clienteID, divida);
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.nomeFantasia = nomeFantasia;
    }

    // setters
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public void setCNPJ(String CNPJ) { this.CNPJ = CNPJ; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    // getters
    public String getRazaoSocial() { return this.razaoSocial; }
    public String getCNPJ() { return this.CNPJ; }
    public String getNomeFantasia() { return this.nomeFantasia; }

}



