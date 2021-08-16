package company;
public class Main {


    public static void main(String[] args) {
        ListaString lista = new ListaString();

        lista = lista.add(lista, "Fillipe");
        lista = lista.add(lista, "Linder");

        lista.printLista(lista);

        lista = lista.remove(lista);

        lista.printLista(lista);

    }
}
