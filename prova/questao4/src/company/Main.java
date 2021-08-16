package company;

public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo(new Ponto(5,5));
        Retangulo retangulo = new Retangulo(new Ponto(5,5), 5,5);

        Ponto centroCirc = circulo.getCentro();
        Ponto centroRet = retangulo.getCentro();

        System.out.println(centroCirc.getX() + " " + centroCirc.getY());
        System.out.println(centroRet.getX() + " " + centroRet.getY());
    }
}
