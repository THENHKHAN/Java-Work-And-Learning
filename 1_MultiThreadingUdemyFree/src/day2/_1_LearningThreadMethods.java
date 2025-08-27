package day2;

import day2.threadmethods.ThreadMethodCollections;

public class _1_LearningThreadMethods {
    public static void main(String[] args) {
        System.out.println("\n\n-------- Starting Thread Methods and there working ---------\n");

        System.out.println("lets print current Thread name - i.e. check main thread created by JVM: " + Thread.currentThread().getName());
                         // lets print current Thread name - i.e. check main thread created by JVM: main
        //  lets change the main thread name :
        Thread.currentThread().setName("Noor Thread");
        System.out.println("After resetting the main thread AFTER Changing Default main THREAD: " + Thread.currentThread().getName()); //
        // After resetting the main thread AFTER Changing Default main THREAD: Noor Thread




//        System.out.println("inifinite : " + 10/0);
        /* See exception  name got change
        Exception in thread "Noor Thread" java.lang.ArithmeticException: / by zero
	at day2._1_LearningThreadMethods.main(_1_LearningThreadMethods.java:16)
         */

        System.out.println("\n-------------      Let's Learn other methods of Thread Class : getName(), setName(), isAlive(), currentThread() methods    --------------------------------   \n");

//            System.exit(1);
            ThreadMethodCollections.myMain();
    }
}