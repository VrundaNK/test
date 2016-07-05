package com.company.thread;

/**
 * Created by vnagpurkar on 7/5/16.
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
