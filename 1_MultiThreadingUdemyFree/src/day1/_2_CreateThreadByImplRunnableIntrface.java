package day1;

// Todo: Creating thread by implementing the Runnable Interface. This will need 5-steps to create thread.
public class _2_CreateThreadByImplRunnableIntrface implements Runnable{ // step-1: To implements Runnable Interface.

    public void run(){  //Step-2:  override the run() method of Thread Cls.
        System.out.println("Hello Run from thread task-2  ");
    }

    public static void main(String[] args) {
        System.out.println("Hello Testing : Creating thread by implementing the Runnable Interface...............");

        _2_CreateThreadByImplRunnableIntrface th = new _2_CreateThreadByImplRunnableIntrface(); // step-3: Instantiate the class which implements the Runnable Interface.
        Thread thread = new Thread(th);// step-4: Create the Thread object. Or we can  direclty pass with new and the class which implements the Runnable Interface.
        //Thread thread = new Thread(new _2_CreateThreadByImplRunnableIntrface());// step-4: like this.
        thread.start(); // Step-5 : To Run the thread  by calling start() method of Thread class, this will implicitly called the run() method. Note: We can't directly call the run(). If we call then it will run but there won't be create any thread.

    }


}
