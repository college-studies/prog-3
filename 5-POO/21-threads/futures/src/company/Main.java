package company;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> tarefa = () -> {
            Random rand = new Random();
            int acc = 0;
            for (int i = 0; i < 100000; i++)
                acc += rand.nextInt(100);
            return acc;
        };

        // cria pool de threads
        ExecutorService threadPoll = Executors.newFixedThreadPool(4);
        Future<Integer> retorno = threadPoll.submit(tarefa);

        while(!retorno.isDone()) {
            System.out.println("A tarefa ainda n foi concluida");
        }

        int resultado = 0;
        System.out.println("Tentando obter o resultado...");
        resultado = retorno.get();

        System.out.println("O resultado é " + resultado);
        threadPoll.shutdown();
    }
}
