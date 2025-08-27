package day2.threadmethods;

import day2.threadmethods.thread.management.and.control.DaemonThread;

//  Basic Thread Operations can be performed by these methods.
public class ThreadMethodCollections extends Thread {

    // getName() - Returning the name of the thread

    public void run(){
        System.out.println("ThreadMethodCollections Thread is performing task under run() methods " );
        System.out.println("Under run() - which thread is ran this run() i.e. Current Thread -- " + Thread.currentThread().getName()); // same as we have in getMyThreadName() i.e. Thread-0
                                    // Thread-0 since it called with the reference of Thread-0 that's y. And if you make another thread then this will print that thread.
        // also since this Thread-0 is the current thread whichever reference of thread will call that will be that current thread.
    }

    public String getMyThreadName(ThreadMethodCollections th){
        System.out.println("Current Thread Name in any normal function **except** run(): " + Thread.currentThread().getName()); // Noor Thread From main()- this is the 1st thread created by JVM itself.
                                            // currentThread is a static method it will only return the main() Thread bcz that can directly get Thread Class. And static method is accessible by Class only then it will be effective.
        System.out.println("Is Thread alive - : " + th.isAlive()); // false
        /*
        Why False:
        ➡️ At this point, you have only constructed the thread object (new ThreadMethodCollections()), but you haven’t called start() yet.
        So isAlive() will always print false.

         */

        return th.getName(); // Thread-0 ,1,2,3 but not main - which means this ThreadMethodCollections thread
        }



    public static void myMain(){

        // this will be call from _1_LearningThreadMethods so all are in this file and not make  _1_LearningThreadMethods more messy.

//        System.out.println("hello is printed by thread name : " + Thread.currentThread().getName()); // Noor Thread
//
//        ThreadMethodCollections th = new ThreadMethodCollections();
//        System.out.println("My Thread Name : " + th.getMyThreadName(th));// this is Thread created - Thread-0
//        th.start();

//        ThreadMethodCollections th2 = new ThreadMethodCollections();
//        System.out.println("My Thread Name : " + th2.getMyThreadName(th2));// this is Thread created - c      so that how it named the thread 0,1,2,3.......etc.
//        th2.start(); // Thread-1 ran this run ().
        // NOTE: If print with Thread.currentThread().getName() here in this function Or call from here to any function that will be main Thread. since it call from main()




//        _1_ThreadMethodCollections th3 = new _1_ThreadMethodCollections();
//        System.out.println("My Thread Name : " + th3.getMyThreadName(th3));// this is Thread created - Thread-3
//        System.out.println("Before calling run() Thread is Alive or not ??? " + th3.isAlive()); // false
//        th3.start();
//        System.out.println("AFTER calling run() Thread is Alive or not ??? " + th3.isAlive()); // true


        // TODO : VVVVVVV Important :
        /*
        logs:

        Before calling run() Thread is Alive or not ??? false
AFTER calling run() Thread is Alive or not ??? true
ThreadMethodCollections Thread is performing task under run() methods
Under run() - which thread is ran this run() i.e. Current Thread -- Thread-0

WHY  --- Before calling run() Thread is Alive or not ??? false              is FALSE

        A thread becomes alive only after you call start(), because that tells the JVM to create a new execution path.

       Step-by-step in your case:

                ThreadMethodCollections th3 = new ThreadMethodCollections();
                → You only created the thread object. No new execution path exists yet. (isAlive() = false)

                th3.start();
                → JVM allocates resources, marks thread as alive, and calls its run() method internally. (isAlive() = true)

                Inside run()
                → Thread.currentThread() shows Thread-0, which is the actual thread executing.

Key rule:

Before start() → isAlive() = false (just an object, no execution path).
After start() but before run() completes → isAlive() = true.
After run() completes → isAlive() = false again.

✅ So, creating a Thread object ≠ running thread.
It’s like buying a car (object created) but not starting the engine (start()). The car exists but isn’t "alive" on the road yet.

false → true → false as the thread goes from new → alive → terminated.
         */





        // TODO:
                // Daemon Thread
        DaemonThread.myMain();


    }

}
