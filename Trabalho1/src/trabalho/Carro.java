package trabalho;

public abstract class Carro implements ValorDiaria {

    @Override
    public void calculaValorDiaria() {
        System.out.println("Interface teste");
    }


    private String placa;
    private String modelo;
    private String descricao;
    private String observacoes;

    private final int carroID;
    private int ano;

    private boolean situacao;

    private double quilometragem;
    private double taxaDiaria;
    private double taxaPorKm;


    // constructor
    public Carro(
                String placa, String modelo,  String descricao, String observacoes,
                int carroID,  int ano,
                boolean situacao,
                double quilometragem,  double taxaDiaria, double taxaPorKm
                )
    {

        this.placa = placa;
        this.modelo = modelo;
        this.descricao = descricao;
        this.observacoes = observacoes;
        this.carroID = carroID;
        this.ano = ano;
        this.situacao = situacao;
        this.quilometragem = quilometragem;
        this.taxaDiaria = taxaDiaria;
        this.taxaPorKm = taxaPorKm;

    }

    // setters
    public void setPlaca(String placa) { this.placa = placa;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public void setObservacoes(String observacoes) {this.observacoes = observacoes;}
    public void setAno(int ano) {this.ano = ano;}
    public void setSituacao(boolean situacao) {this.situacao = situacao;}
    public void setQuilometragem(double quilometragem) {this.quilometragem = quilometragem;}
    public void setTaxaDiaria(double taxaDiaria) {this.taxaDiaria = taxaDiaria;}
    public void setTaxaPorKm(double taxaPorKm) {this.taxaPorKm = taxaPorKm;}

    // getters
    public int getID() { return this.carroID; }
    public String getPlaca() { return this.placa; }
    public String getModelo() { return this.modelo; }
    public String getDescricao() { return this.descricao; }
    public String getObservacoes() { return this.observacoes; }
    public int getAno() { return this.ano; }
    public boolean getSituacao() { return this.situacao; }
    public double getQuilometragem() { return this.quilometragem; }
    public double getTaxaDiaria() { return this.taxaDiaria; }
    public double getTaxaPorKm() { return this.taxaPorKm; }
}
