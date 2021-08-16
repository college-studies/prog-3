package company;

public class Empregado implements Mensuravel {
    String nome;
    double salario;

    public Empregado(String nome, int salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getSalario() { return this.salario;}

    public double getMedida() {
        return this.getSalario();
    }

}
