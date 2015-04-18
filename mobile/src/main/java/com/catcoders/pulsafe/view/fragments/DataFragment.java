package com.catcoders.pulsafe.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.catcoders.pulsafe.R;
import com.catcoders.pulsafe.model.entity.Log;
import com.catcoders.pulsafe.mvp.presenter.PeoplePresenter;
import com.catcoders.pulsafe.view.activity.MainActivity;
import com.catcoders.pulsafe.view.adapter.PeopleAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mqttservice.mqtt.Client;


public class DataFragment extends Fragment {

    private PeopleAdapter mPeopleAdapter;
    private PeoplePresenter mPeoplePresenter;

    @InjectView(R.id.et_user) protected EditText etUser;
    @InjectView(R.id.et_latitude) protected EditText etLatitude;
    @InjectView(R.id.et_longitude) protected EditText etLongitude;
    @InjectView(R.id.et_bpm) protected EditText etBPM;

    public static int MESSAGE_PUBLISH_INFO = 0;

    private static String TAG = "DataFragement";


    public DataFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    private Client getMqttClient() {
        return ((MainActivity)getActivity()).getMqttClient();
    }

    public void publishInfo() {
        if (getMqttClient() != null) {
            Toast.makeText(getActivity(), "Creating message", Toast.LENGTH_SHORT).show();
                Log log = new Log("",
                        "HEARTRATE",
                        1,
                        etBPM.getText().toString(),
                        etUser.getText().toString(),
                        "(" + etLatitude.getText().toString() + "," + etLatitude.getText().toString() + ")");
                getMqttClient().publish("pulsafe/users/" + etUser.getText() + "/HEARTRATE", Log.jsonSerialized(log));
            android.util.Log.i(TAG, "Publicada info: " + Log.jsonSerialized(log));
        }
        else {
            Toast.makeText(getActivity(), "App is no connected to broker", Toast.LENGTH_SHORT).show();
        }
    }




}
