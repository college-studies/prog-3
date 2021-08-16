package company;

public class ListaString {
    No inicio;

    static class No {
        String valor;
        No proximo;

        No(String v) {
            valor = v;
        }
    }


    ListaString add(ListaString lista, String valor) {
        No novo_no = new No(valor);
        novo_no.proximo = null;

        if (lista.inicio == null ) {
            lista.inicio = novo_no;
        } else {
            No ultimo = lista.inicio;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }

            ultimo.proximo = novo_no;
        }

        return lista;
    }

    ListaString remove(ListaString lista) {
        if (lista.inicio != null) {
            No ultimo, aux;

            ultimo = lista.inicio;
            aux = lista.inicio;

            while (ultimo.proximo != null) {
                aux = ultimo;
                ultimo = ultimo.proximo;
            }
            aux.proximo = null;
        }
        return lista;
    }

    void printLista(ListaString lista) {
        No noAtual = lista.inicio;

        System.out.print("Lista : ");

        while( noAtual != null) {
            System.out.print(noAtual.valor + " ");

            noAtual = noAtual.proximo;
        }
        System.out.print("\n");
    }

}
