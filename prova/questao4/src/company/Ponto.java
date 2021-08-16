package company;

public class Ponto {
    double x, y;

    Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o){
        return false;
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }



}
