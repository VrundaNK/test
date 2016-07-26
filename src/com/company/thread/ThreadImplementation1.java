package com.company.thread;

/**
 * Created by vnagpurkar on 7/5/16.
 */
/*
Instance of ThreadImplementation1 class is passed to Thread class
ThreadImplementation1 instance = new ThreadImplementation1();
Thread thread = new Thread(instance);

thread.start(); // this will start the thread
 */
public class ThreadImplementation1 implements Runnable {

    public int count = 0;
    @Override
    public void run() {

        while(count < 5) {

            try {
                System.out.println("count " + count);
                Thread.sleep(1000);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
