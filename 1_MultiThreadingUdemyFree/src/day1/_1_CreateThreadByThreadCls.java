package day1;

import java.util.Arrays;
import java.util.ArrayList;

// Todo: Creating thread by extending the Thread class: This will need 4-steps to create thread.
public class _1_CreateThreadByThreadCls extends Thread{ // step-1: To extends Thread Class


    public void run(){  //Step-2:  override the run() method of Thread Cls.
        System.out.println("Hello Run from thread task-1 ");
    }

    public static void main(String[] args) {
        System.out.println("Hello Testing : Creating thread by extending the Thread class...............");
        _1_CreateThreadByThreadCls t = new _1_CreateThreadByThreadCls(); // step-3: Instantiate the class which extended the Thread class.
        t.start(); // Step-4 : To Run the thread  by calling start() method of Thread class, this will implicitly called the run() method. Note: We can't directly call the run(). If we call then it will run but there won't be create any thread.

    }


}
