package day1.threadexecutioncaseclasses;

import java.util.Arrays;

public class MultipleTasksMultipleThreads extends Thread{
    @Override
    public void run(){
        System.out.println("Task -1 From multipleTasksMultipleThreads Thread.");
        for (int number: Arrays.asList(1, 2, 3, 4)){
            System.out.println("Loop from Thread-1 : value  ---> "  + number);
        }
    }
}


