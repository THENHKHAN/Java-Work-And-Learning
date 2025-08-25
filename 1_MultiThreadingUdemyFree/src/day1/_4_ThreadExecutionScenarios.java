package day1;

/*
 We're covering these 4 classic multithreading use cases:

 1. Single task from a single thread
    - One thread performs one task.
    - We'll create a class that extends the Thread class, override the run() method, and call it via a Thread object using start().
    - Example: A single thread printing a message in a loop.

 2. Single task from multiple threads
    - Multiple threads perform the same task concurrently.
    - We'll create one task (e.g., print logic) and run it using multiple Thread objects.
    - Example: Several threads printing the same message simultaneously.

 3. Multiple tasks from a single thread ---- Special - we don't do this - see below - explained in detail with example.
    - One thread sequentially performs multiple different tasks.
    - We'll define multiple methods (tasks) and call them in sequence from a single thread (e.g., main thread).
    - Example: A single thread executing methodA(), then methodB().

 4. Multiple tasks from multiple threads
    - Multiple threads each perform different tasks concurrently.
    - We'll create different Runnable or Thread classes, each handling a separate task, and execute them in parallel.
    - Example: Thread A prints numbers, Thread B prints characters.

 We're grouping all of these in one class for demonstration and practice.
*/

/*
     public static void singleTaskSingleThread() { ... }

    public static void singleTaskMultipleThreads() { ... }

    public static void multipleTasksSingleThread() { ... }

    public static void multipleTasksMultipleThreads() { ... }

    inside these will create so we can  manage and understand easily. They will be call from main()
 */

/*
Since we want to ignore the main() thread in logic which is always present and created by JVM. So there will always a thread exists and i.e. main(), but still note its existence, here’s a short comment block you can use in your code:

 Note about main() and threads:

 - The `main()` method is always executed by a thread called the **main thread**, which is created by the JVM.
 - It is the first thread in any Java program and acts as the entry point.
 - Even if we don’t create any threads manually, the main thread is always running in the background.
 - In our examples, we’ll create and use custom threads, and we will **ignore the main thread's role** for clarity.

 */


import day1.threadexecutioncaseclasses.MultipleTasksMultipleThreads;
import day1.threadexecutioncaseclasses.MultipleTasksMultipleThreads2;
import day1.threadexecutioncaseclasses.MultipleTasksMultipleThreads3;
import day1.threadexecutioncaseclasses.SingleTaskSingleThread;

public class _4_ThreadExecutionScenarios {

    public static void main(String[] args) {
        System.out.println("------- Starting to cover multiple cases to create and do some work in Multithreading ---------------- ");

        // will call from here:

//        1. Single task from a single thread

//        SingleTaskSingleThread singleThreadSingleTask = new SingleTaskSingleThread(); // thread created
//        singleThreadSingleTask.start();// it will run the SingleTaskSingleThread thread run() function as ONE TASK.
            /*
            OUTPUT:
            Task -1 From SingleTasksSingleThread Thread.
             */

//        2. Single task from multiple threads
//        System.out.println("Task execution started by Thread-1  ......");
//        SingleTaskSingleThread th1 = new SingleTaskSingleThread(); // thread-1 created
//        th1.start(); // it will by 1st thread obj
//
//        System.out.println("Task execution started by Thread-2  ......");
//        SingleTaskSingleThread th2 = new SingleTaskSingleThread(); // thread-2 created
//        th2.start();
                        // similarly we can have multiple thread.

         /*
            OUTPUT:
Task execution started by Thread-1  ......
Task execution started by Thread-2  ......
Task -1 From SingleTasksSingleThread Thread.
Task -1 From SingleTasksSingleThread Thread.
Val : 0
Val : 1
Val : 0
Val : 2
Val : 3
Val : 1
Val : 2
Val : 3
NOTE: You can see that all thread (here two) are executing parallel.
             */

//        3. Multiple tasks from a single thread --- No use of it since once the thread goes in dead state and when we call start with the same thread it will throw IllegaState Exception


//        4. Multiple tasks from multiple threads
        MultipleTasksMultipleThreads th1 = new MultipleTasksMultipleThreads(); // created thread-1
        th1.start();

        MultipleTasksMultipleThreads2 th2 = new MultipleTasksMultipleThreads2(); // created thread-1
        th2.start();

        MultipleTasksMultipleThreads3 th3 = new MultipleTasksMultipleThreads3();
        th3.start();
        // instead of creating separate file we can define in a single like in this fill and extends Thread all three classes (mostly used). I created to understand each flow.
        /*
        sample output : with just a print statement :
        Task -1 From multipleTasksMultipleThreads Thread.
        Task -2 From multipleTasksMultipleThreads2 Thread.
        Task -3 From MultipleTasksMultipleThreads3 Thread.

        NOTE: Here, its seems like they ran one after other but no , they actually ran together parallel. Let me write loop so we can see by printing.
         */

        /*

 Task -1 From multipleTasksMultipleThreads Thread.
Task -2 From multipleTasksMultipleThreads2 Thread.
Task -3 From MultipleTasksMultipleThreads3 Thread.
Loop from Thread-1 : value  ---> 1
Loop from Thread-1 : value  ---> 2
Loop from Thread-1 : value  ---> 3
Loop from Thread-1 : value  ---> 4
Loop from Thread-3 : value  ---> 100
Loop from Thread-3 : value  ---> 200
Loop from Thread-3 : value  ---> 300
Loop from Thread-3 : value  ---> 400
Loop from Thread-2 : value  ---> 10
Loop from Thread-2 : value  ---> 20
Loop from Thread-2 : value  ---> 30
Loop from Thread-2 : value  ---> 40

NOTE: See we have called thread 1, 2, and then 3 but thread executed 1 , 3 and then 2. If you run same program you could see 2,3 and then 1 or 1, 2, then 3.
            they all executing in parallel.

  ===>  WHICH thread will execute 1st we can't guarantee because it decided by JVM/ThreadSchedular etc. In future will look in detail how we can prioritize the thread.
         */

    }
    
}

/*
##### Special case 3 - T.S : 10:00 ===>   https://www.youtube.com/watch?v=hJXJgHmso2M&list=PLlhM4lkb2sEh1pBs0KBb63PlKKqRx6M1a&index=5

/*
 Note on Case 3: Multiple tasks from a single thread -No use since if use method overloading so we have to defince multiple run() which is not possible since Thread
                            have only a single run() method that does not take argument.


 - This means one thread runs several tasks one after another, NOT at the same time.
 - For example, if the thread runs music, then video, then timer, it finishes one fully before starting the next.
 - So, there is NO parallel or simultaneous execution here.
 - This is fine for simple or linear tasks, but NOT good for apps like ** VLC ** that need music, video, and timer all running together.
 - Real apps needing this kind of parallelism use multiple threads (Case 4).
 - Case 3 helps us understand how tasks run sequentially and is a good foundation before learning about multithreading.
 - But it’s limited when concurrency or multitasking is required.
*/

/*
For Case - 4 QA-

 FAQ: Why create separate classes for different tasks in multiple threads?

 - Each thread needs its own task defined in the run() method.
 - Different classes (or Runnable implementations) keep tasks cleanly separated and modular.
 - It prevents mixing multiple tasks inside one run() method, which can complicate logic and synchronization.
 - This approach improves code readability, maintenance, and debugging.
 - While possible to use one class with multiple methods, it often leads to confusion and tightly coupled code.
*/
