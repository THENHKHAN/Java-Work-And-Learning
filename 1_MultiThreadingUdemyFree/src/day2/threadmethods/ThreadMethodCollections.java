package day2.threadmethods;

//  Basic Thread Operations can be performed by these methods.
public class ThreadMethodCollections extends Thread {

    // getName() - Returning the name of the thread

    public void run(){
        System.out.println("ThreadMethodCollections Thread is performing task " );
    }

    public static String getMyThreadName(ThreadMethodCollections th){
            return th.getName();
        }
}
