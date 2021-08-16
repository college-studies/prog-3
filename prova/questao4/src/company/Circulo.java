package company;

public class Circulo extends Shape{

    Circulo(Ponto a) {
        super(a);
    }

    @Override
    public Ponto getCentro() {
        return a;
    }
}
