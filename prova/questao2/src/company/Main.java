package company;

public class Main {

    public static void main(String[] args) {

        Ponto ponto = new Ponto(3,4);

        Ponto ponto2 = ponto.translado(1,3).escala(0.5);

        System.out.println(ponto.getX() +  " " + ponto.getY() );
        System.out.println(ponto2.getX() +  " " + ponto2.getY() );

    }
}
