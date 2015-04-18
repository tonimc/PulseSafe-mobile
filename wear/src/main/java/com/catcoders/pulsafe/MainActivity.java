package com.catcoders.pulsafe;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends Activity implements SensorEventListener {

    private static final String TAG = MainActivity.class.getName();


    private SensorManager mSensorManager;

    private Sensor mHeartRateSensor;
    private TextView mRateTextView;
    private static final int SENSOR_TYPE_HEARTRATE = 65562;

    private CountDownLatch latch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "On CREATE!");
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mRateTextView = (TextView) stub.findViewById(R.id.rate);

            }
        });

        mSensorManager = ((SensorManager)getSystemService(SENSOR_SERVICE));
        mHeartRateSensor = mSensorManager.getDefaultSensor(SENSOR_TYPE_HEARTRATE);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] > 0) {
            Log.d(TAG, "sensor event: " + sensorEvent.accuracy + " = " + sensorEvent.values[0]);
            mRateTextView.setText(String.valueOf(sensorEvent.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Registered" + this.mHeartRateSensor + " " + this.mSensorManager);
        mSensorManager.registerListener(this, this.mHeartRateSensor, 10);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Stop ");
        mSensorManager.unregisterListener(this);
    }
}
