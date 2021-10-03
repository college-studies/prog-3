package company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread thread1 = new MyThread();

        // other way of creating a thread
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        thread1.start();

        // pause main thread until thread1 is completely done
        // thread1.join(3000);

        thread2.start();

        // an exception doesnt affect other threads
        System.out.println(1/0);
    }
}
