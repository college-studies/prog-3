package company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        // define a tarefa 1
        Runnable tarefa1 = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println("Hello" + i);
        };

        // define a tarefa 2
        Runnable tarefa2 = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println("Goodbye" + i);
        };

        // Cria o serviço executor (pool de threads / vida curta)
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(tarefa1);
        executor.execute(tarefa2);
        executor.shutdown();
    }
}
