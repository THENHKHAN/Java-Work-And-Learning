package day1.threadexecutioncaseclasses;

// will handle both 1-2 scenario
public class SingleTaskSingleThread extends Thread{

    @Override
    public void run(){
        System.out.println("Task -1 From SingleTasksSingleThread Thread.");
        for (int i = 0; i < 4 ; i++) {
            System.out.println("Val : " + i);
        }
    }
}
