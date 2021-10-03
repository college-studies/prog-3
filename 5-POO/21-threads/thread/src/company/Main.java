package company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // how many threads are running
        System.out.println(Thread.activeCount());

        // get thread name
        System.out.println(Thread.currentThread().getName());

        // change thread name
        Thread.currentThread().setName("MAIIIIIIN");
        System.out.println(Thread.currentThread().getName());

        // check priority - the higher the number, higher the priority is (scale 1 - 10)
        System.out.println(Thread.currentThread().getPriority());

        // change priority
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());

        // Check if thread is alive
        System.out.println(Thread.currentThread().isAlive());

        // thread sleep
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("You are done");


        // create a second thread - by creating a child class
        MyThread thread2 = new MyThread();

        // check if thread is daemon
        // System.out.println(thread2.isDaemon());

        // make thread daemon
        thread2.setDaemon(true);

        thread2.start();
        System.out.println(thread2.isAlive());
        System.out.println(thread2.getName());

        thread2.setName("2nd thread");
        System.out.println(thread2.getName());

        // by default the 2nd thread inherites the priority of the main priority

        thread2.setPriority(1);
        System.out.println(thread2.getPriority());

        System.out.println(Thread.activeCount());


        // there are 2 types of threads
        // daemon threads is a low priority thread that runs in background to perform tasks that runs in background
        // such as gargabe collections and JVM terminates itself when all user threads (non-daemon threads) finish
        // their execution


    }
}
