package company;

public class Retangulo extends Shape{
    Ponto topLeft;
    double largura;
    double altura;

    Retangulo(Ponto topLeft, double largura, double altura) {
        super(topLeft);
        this.topLeft = topLeft;
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public Ponto getCentro() {
        return new Ponto((largura/2), (altura/2));
    }
}
