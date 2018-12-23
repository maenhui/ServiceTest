package com.maeh.service.testservice;

public class MyRunnable implements Runnable {

    public static final String TAG = MyRunnable.class.getSimpleName();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //System.out.println();
            //System.out.println(i);
            //Log.i(TAG, "run: " + i);
        }
    }
}