package company;

public final class Ponto {
    private final double x;
    private final double y;

    Ponto() {
        this.x = 0;
        this.y = 0;
    }

    Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return this.x;}
    public double getY() { return this.y;}

    Ponto translado(double x, double y) {
        return new Ponto(this.getX() + x, this.getY() + y);
    }

    Ponto escala(double x) {
        return new Ponto(this.getX() * x , this.getY() * x);
    }
}
