package company;

public abstract class Shape {
    Ponto a;

    Shape(Ponto a) {
        this.a = a;
    }

    public Ponto getA() { return this.a; }

    public void moveBy(double dx, double dy) {

    }


    public abstract Ponto getCentro();
}
