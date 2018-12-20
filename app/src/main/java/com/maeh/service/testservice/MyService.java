/*
 * Copyright (c) 2018. Parrot Faurecia Automotive S.A.S. All rights reserved.
 */

package com.maeh.service.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onCreate: ");
        }
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onStartCommand: ");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onDestroy: ");
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onBind: ");
        }
        // TODO: Return the communication channel to the service.
        return mDownloadBinder;
    }

    public DownloadBinder mDownloadBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            if (BuildConfig.DEBUG_LOG) {
                Log.d(TAG, "startDownload: ");
            }
        }

        public int getProgress() {
            if (BuildConfig.DEBUG_LOG) {
                Log.d(TAG, "getProgress: ");
            }
            return 0;
        }
    }

}
