package day1.threadexecutioncaseclasses;

import java.util.Arrays;

public class MultipleTasksMultipleThreads3 extends Thread {
    @Override
    public void run(){
        System.out.println("Task -3 From MultipleTasksMultipleThreads3 Thread.");
        for (int number: Arrays.asList(100, 200, 300, 400)){
            System.out.println("Loop from Thread-3 : value  ---> "  + number);
        }
    }
}
