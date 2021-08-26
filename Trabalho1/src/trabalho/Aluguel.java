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
    public Aluguel(
                    LocalDate inicLoc, LocalDate fimLoc,
                    int clienteID, int carroID, int aluguelID,
                    double valorAluguel, int tipoAluguel
                   )
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
    public void setInicioLocacao(LocalDate inicLoc) { this.inicioLocacao = inicLoc; }
    public void setFimLocacao(LocalDate fimLoc) { this.fimLocacao = fimLoc; }
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
        boolean dia_inicio, dia_devolucao;

        LocalDate inicio_locacao = this.inicioLocacao;
        LocalDate fim_locacao = this.fimLocacao == null ? LocalDate.now() : this.fimLocacao;

        dia_inicio = inicio_locacao.isAfter(inicio) || fim_locacao.isEqual(inicio);
        dia_inicio = dia_inicio && (inicio_locacao.isBefore(fim) || inicio_locacao.isEqual(fim));

        dia_devolucao = fim_locacao.isAfter(inicio) || fim_locacao.isEqual(inicio);
        dia_devolucao = dia_devolucao && (fim_locacao.isBefore(fim) || fim_locacao.isEqual(fim));

        return dia_inicio || dia_devolucao;
    }

}
