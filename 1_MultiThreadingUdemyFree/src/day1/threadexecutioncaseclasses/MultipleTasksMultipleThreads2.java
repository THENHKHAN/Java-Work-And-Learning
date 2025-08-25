package day1.threadexecutioncaseclasses;

import java.util.Arrays;

public class MultipleTasksMultipleThreads2 extends Thread{
    @Override
    public void run(){
        System.out.println("Task -2 From multipleTasksMultipleThreads2 Thread.");
        for (int number: Arrays.asList(10, 20, 30, 40)){
            System.out.println("Loop from Thread-2 : value  ---> "  + number);
        }
    }
}
