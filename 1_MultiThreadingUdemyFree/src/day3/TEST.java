package day3;

public class TEST extends Thread{

    public void run() {
        System.out.println("Thread  " + Thread.currentThread().getName()
                + ", is Daemon: " + Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
//        System.out.println("Hello from main");
        TEST thread1 = new TEST();
        TEST thread2 = new TEST();
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();

//        System.out.println("Hello from main END");


    }
}
