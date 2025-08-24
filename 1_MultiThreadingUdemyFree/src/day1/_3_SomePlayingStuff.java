package day1;

public class _3_SomePlayingStuff extends Thread {


    @Override
    public void run(){
        System.out.println("Same signature as in superclass - run()");
    }

    public void run(int a ){
        System.out.println("Overloaded run method with one argument");
        System.out.println("Value : " + a);
    }

    @Override
    public void start(){ // if we override as well as run() then start() method will run.
        // This overrides the Thread class's start() method,
        // so the custom run() will NOT be called unless you call it explicitly.
        System.out.println("start() method overridden from Thread class");
    }

    public static void main(String[] args) {

        Thread th = new _3_SomePlayingStuff();
        th.start(); // if we overload the run() then it will call the run which has same signature as in the superClass or Interface.
                    // OUTPUT- Run-1

        /*

                // Explanation:
        // Even though run() is overridden, because start() is also overridden,
        // the start() method here does NOT call run().
        // So only the overridden start() method is executed.
        //
        // Note: Overloading run() (like run(int)) does NOT affect thread behavior.
        // Only the no-argument run() is used by Thread.
         */


        /*

        ✅ Summary of Key Concepts:
--> Overriding run() allows your thread to execute custom logic when start() is called.
--> Overloading run(int a) or any other signature has no impact on thread behavior.
--> If you override start(), you must manually call run() if you still want the thread's logic to execute.
--> It's not recommended to override start() unless you have a specific reason.
         */

        /*
        Yes, your current logic does not create a new thread, because you overrode start() and did not call super.start() in the start() overloaded mehtod.
        Therefore, run() is not called at all.
       ✅  You should not override start(), or if you must override it (not typical), you should call super.start() inside it.
                ✅ Option 1: Don't override start()
                ✅ Option 2: If you really need to override start() (not recommended):
        if you want then -

                     @Override
                    public void start() {
                        super.start(); // This ensures the thread starts
                        System.out.println("Custom logic in start()");
                    }
         */
    }
}
