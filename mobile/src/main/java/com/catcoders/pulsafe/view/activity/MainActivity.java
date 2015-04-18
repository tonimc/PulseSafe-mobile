package com.catcoders.pulsafe.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.catcoders.pulsafe.R;
import com.catcoders.pulsafe.view.fragments.DataFragment;
import com.catcoders.pulsafe.view.fragments.HomeFragment;
import com.catcoders.pulsafe.view.fragments.MapFragment;
import com.catcoders.pulsafe.view.fragments.PeopleFragment;

import org.eclipse.paho.client.mqttv3.MqttException;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import mqttservice.mqtt.Client;


public class MainActivity extends MaterialNavigationDrawer  {

    private static final String TAG = MainActivity.class.getName();

    public Client mqttClient;

    public Client getMqttClient() {
        if(mqttClient==null) {
            createClientMqtt();
        }
        return mqttClient;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        this.disableLearningPattern();
        this.setDrawerHeaderImage(R.drawable.drawer_bg_top);

        // create sections
        this.addSection(newSection(getString(R.string.section_home), R.drawable.ic_home, new HomeFragment()));
        this.addSection(newSection(getString(R.string.section_people), R.drawable.ic_people, new PeopleFragment()));
        this.addSection(newSection(getString(R.string.section_map), R.drawable.ic_map, new MapFragment()));
        this.addSection(newSection(getString(R.string.section_data), R.drawable.ic_data, new DataFragment()));

        createClientMqtt();
    }

    private void createClientMqtt() {
        try {
            mqttClient = new Client(this);
        } catch (MqttException e) {
            Toast.makeText(this, "Problem connecting to broker", Toast.LENGTH_SHORT).show();
            android.util.Log.e(TAG, e.getMessage());
            android.util.Log.e(TAG, "reason " + e.getReasonCode());
            android.util.Log.e(TAG, "msg " + e.getMessage());
            android.util.Log.e(TAG, "loc " + e.getLocalizedMessage());
            android.util.Log.e(TAG, "cause " + e.getCause());
            android.util.Log.e(TAG, "excep " + e);
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
            if(msg.what == DataFragment.MESSAGE_PUBLISH_INFO){
                Toast.makeText(MainActivity.this, "Publishing info", Toast.LENGTH_SHORT).show();
                DataFragment fg;
                try {
                    fg = (DataFragment)getSupportFragmentManager().findFragmentById(R.id.frame_container);
                    fg.publishInfo();
                } catch (Exception e) {

                }

            } else{
                Toast.makeText(MainActivity.this, "Data received", Toast.LENGTH_SHORT).show();
                PeopleFragment fg;
                String newLog = msg.getData().getString("log");
                try {
                    fg = (PeopleFragment)getSupportFragmentManager().findFragmentById(R.id.frame_container);
                    fg.addNewDataLog(newLog);
                } catch (Exception e) {

                }
            }
        }
    };


}
