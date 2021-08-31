package trabalho;

import java.time.LocalDate;

public class Aluguel
{

    // Definição de Atributos
    private LocalDate inicioLocacao, fimLocacao;
    private int clienteID;
    private int carroID;
    private int aluguelID;
    private int tipoAluguel;
    private double valorAluguel;

    // constructor
    public Aluguel(LocalDate inicLoc, LocalDate fimLoc,int clienteID, int carroID, int aluguelID,double valorAluguel, int tipoAluguel)
    {
        this.inicioLocacao = inicLoc;
        this.fimLocacao = fimLoc;
        this.clienteID = clienteID;
        this.carroID = carroID;
        this.aluguelID = aluguelID;
        this.valorAluguel = valorAluguel;
        this.tipoAluguel = tipoAluguel;
    }

    // setters
    public void setInicioLocacao(LocalDate d) { this.inicioLocacao = d; }
    public void setFimLocacao(LocalDate d) { this.fimLocacao = d; }
    public void setClienteID(int clienteID) { this.clienteID = clienteID; }
    public void setCarroID(int carroID) { this.carroID = carroID; }
    public void setAluguelID(int aluguelID) { this.aluguelID = aluguelID; }
    public void setValorAluguel(double valorAluguel) { this.valorAluguel = valorAluguel; }
    public void setTipoAluguel(int tipoAluguel) { this.tipoAluguel = tipoAluguel; }

    // getters
    public LocalDate getInicioLocacao() { return this.inicioLocacao; }
    public LocalDate getFimLocacao() { return this.fimLocacao; }
    public int getClienteID() { return this.clienteID; }
    public int getCarroID() { return this.carroID; }
    public int getAluguelID() { return this.aluguelID; }
    public int getTipoAluguel() { return this.tipoAluguel; }
    public double getValorAluguel() { return this.valorAluguel; }


    // Auxiliar
    public boolean calculaTempoAluguel(LocalDate inicio, LocalDate fim)
    {
        LocalDate dataI = this.inicioLocacao;
        LocalDate dataF = this.fimLocacao == null ? LocalDate.now() : this.fimLocacao;
        boolean dI, dF;

        dI = dataI.isAfter(inicio) || dataI.isEqual(inicio);
        dI = dI && (dataI.isBefore(fim) || dataI.isEqual(fim));

        dF = dataF.isAfter(inicio) || dataF.isEqual(inicio);
        dF = dF && (dataF.isBefore(fim) || dataF.isEqual(fim));


        return dI || dF;
    }

}
