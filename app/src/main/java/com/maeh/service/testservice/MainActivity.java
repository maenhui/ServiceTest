package com.maeh.service.testservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private MyService.DownloadBinder mDownloadBinder;

    public ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (MyService.DownloadBinder) service;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onCreate: ");
        }
        setContentView(R.layout.activity_main);

        // Test runnable
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        // Start and stop service
        Button startService = findViewById(R.id.start_service);
        Button stopService = findViewById(R.id.stop_service);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        // Bind/Unbind service
        Button bindService = findViewById(R.id.bind_service);
        Button unbindService = findViewById(R.id.unbind_service);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (BuildConfig.DEBUG_LOG) {
            Log.d(TAG, "onClick: ");
        }
        Intent serviceIntent = new Intent(this, MyService.class);
        switch (v.getId()) {
            case R.id.start_service:
                startService(serviceIntent);
                break;
            case R.id.stop_service:
                stopService(serviceIntent);
                break;
            case R.id.bind_service:
                bindService(serviceIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(mServiceConnection);
                break;
            default:
                break;
        }
    }
}