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


public class _4_ThreadExecutionScenarios {



    public


}

/*
##### Special case 3 - T.S : 10:00 ===>   https://www.youtube.com/watch?v=hJXJgHmso2M&list=PLlhM4lkb2sEh1pBs0KBb63PlKKqRx6M1a&index=5

/*
 Note on Case 3: Multiple tasks from a single thread

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

/* REF

public class _4_ThreadExecutionScenarios {

    // 1. Single task from a single thread
    public static void singleTaskSingleThread() {
        class SingleTaskThread extends Thread {
            public void run() {
                System.out.println("Thread task is running (Single Task, Single Thread)");
            }
        }

        SingleTaskThread t = new SingleTaskThread();
        t.start();
    }

    // 2. Single task from multiple threads
    public static void singleTaskMultipleThreads() {
        class SharedTask extends Thread {
            public void run() {
                System.out.println("Shared task running from: " + Thread.currentThread().getName());
            }
        }

        SharedTask t1 = new SharedTask();
        SharedTask t2 = new SharedTask();

        t1.start();
        t2.start();
    }

    // 3. Multiple tasks from a single thread
    public static void multipleTasksSingleThread() {
        class TaskPerformer {
            void taskOne() {
                System.out.println("Performing Task 1");
            }

            void taskTwo() {
                System.out.println("Performing Task 2");
            }
        }

        TaskPerformer performer = new TaskPerformer();
        performer.taskOne();
        performer.taskTwo();
    }

    // 4. Multiple tasks from multiple threads
    public static void multipleTasksMultipleThreads() {
        class TaskOne extends Thread {
            public void run() {
                System.out.println("Task 1 is running in " + Thread.currentThread().getName());
            }
        }

        class TaskTwo extends Thread {
            public void run() {
                System.out.println("Task 2 is running in " + Thread.currentThread().getName());
            }
        }

        new TaskOne().start();
        new TaskTwo().start();
    }

    public static void main(String[] args) {
        // Uncomment one at a time to test each case clearly

        // singleTaskSingleThread();
        // singleTaskMultipleThreads();
        // multipleTasksSingleThread();
        // multipleTasksMultipleThreads();
    }
}
 */