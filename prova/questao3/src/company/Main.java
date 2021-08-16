package company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Empregado empregado1 = new Empregado("Fillipe", 1200);
        Empregado empregado2 = new Empregado("Isabella", 1200);
        Empregado empregado3 = new Empregado("Waber", 15000);

        ArrayList<Mensuravel> Empregado = new ArrayList<Mensuravel>();
        Empregado.add(empregado1);
        Empregado.add(empregado2);
        Empregado.add(empregado3);

        Media media = new Media();

        System.out.println(media.media(Empregado));
    }
}
