package company;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<Integer> tarefa1 = () -> {
            Random rand = new Random();
            int total = 0;
            for(int i=0; i< 1000; i++)
                total += rand.nextInt(100);
            return total;
        };

        Supplier<Integer> tarefa2 = () -> {
            Random rand = new Random();
            return rand.nextInt(100);
        };

        // Executa thread de forma assincrona
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> retorno1 = CompletableFuture.supplyAsync(tarefa1, threadPool);
        System.out.println("Aguardando a finalização da thread 1...");
        retorno1.thenAccept((Integer valor) -> System.out.println("Thread 1 retornou: " + valor));
        CompletableFuture<Integer> retorno2 = CompletableFuture.supplyAsync(tarefa2, threadPool);
        System.out.println("Aguardando a finalização da thread 2...");
        retorno1.thenAccept((Integer valor) -> System.out.println("Thread 2 retornou: " + valor));

        for (int i = 0; i < 5; i++ ) {
            System.out.println("Aguardando a finalização...");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
