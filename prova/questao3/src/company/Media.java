package company;

import java.util.ArrayList;

public class Media {

    double media(ArrayList<Mensuravel> lista) {
        double aux = 0;

        for (Mensuravel x: lista) {
            aux = aux + x.getMedida();
        }

        return aux / lista.size();
    }
}
