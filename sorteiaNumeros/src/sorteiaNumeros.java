import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class sorteiaNumeros {
        public static void main(String[] args) {
            //criando o arraylist
            ArrayList<Integer> numeros = new ArrayList<>();
            for(int i = 0; i<50; i++)
                numeros.add(i);

            //fazendo o sorteio
            int[] valoresSorteados = new int[6];
            for (int i=0; i < valoresSorteados.length; i++) {
                int id = sorteia(numeros);
                valoresSorteados[i] = numeros.remove(id);
            }

            Arrays.sort(valoresSorteados);
            System.out.println("Os valores sorteados foram: ");
            System.out.println(Arrays.toString(valoresSorteados));

        }

        public static int sorteia(ArrayList<Integer> array) {
            Random geradorNumeroAleatorio = new Random();
            return geradorNumeroAleatorio.nextInt(array.size());
        }
}
