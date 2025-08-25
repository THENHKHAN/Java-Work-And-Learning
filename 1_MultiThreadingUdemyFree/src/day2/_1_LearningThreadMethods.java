package day2;

import day2.threadmethods.ThreadMethodCollections;

public class _1_LearningThreadMethods {
    public static void main(String[] args) {
        System.out.println("-------- Starting Thread Methods and there working ---------");

        ThreadMethodCollections th = new ThreadMethodCollections(); // thread created.
//        th.start();
        System.out.println("Current thread isAlive -1 : " + th.isAlive());
        System.out.println("Current thread name : " + ThreadMethodCollections.getMyThreadName(th));
        System.out.println("Current thread isAlive -2: " + th.isAlive());
    }
}