package com.company.thread;

/**
 * Created by vnagpurkar on 7/5/16.
 */
public class ThreadImplementation2 extends Thread {

    public int count = 0;
    public void run() {

        while(count < 5) {

            try {
                Thread.sleep(1000);
                System.out.println(count);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
