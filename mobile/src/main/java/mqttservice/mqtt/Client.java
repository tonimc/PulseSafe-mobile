package mqttservice.mqtt;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.catcoders.pulsafe.view.activity.MainActivity;
import com.catcoders.pulsafe.view.fragments.DataFragment;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Client extends MqttClient {

    public static String BROKER_HOST = "broker.mqttdashboard.com";
    public static int BROKER_PORT = 1883;
    public static int QOS = 2;
    private final String COMMAND_PUBLISH = "pulsafe/command/publish";;

    protected MainActivity context;

    public Client(MainActivity context) throws MqttException {
        super("tcp://" + BROKER_HOST + ":" + BROKER_PORT, "pulsafe", new MemoryPersistence());

        this.context = context;

        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connect(connOpts);
        setCallback(new CommandManager());

        subscribe(COMMAND_PUBLISH);
        subscribe("pulsafe/users/#");
    }

    public void publish(String topic, String message) {
        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
        mqttMessage.setQos(QOS);
        try {
            publish(topic, mqttMessage);
        }
        catch (MqttException e) {
            Toast.makeText(context, "Problem publishing message", Toast.LENGTH_SHORT).show();
        }
    }


    protected class CommandManager implements MqttCallback {

        @Override
        public void connectionLost(Throwable throwable) {

        }

        @Override
        public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
            Log.d("CommandManager", "MESSAGE RECEIVED "+topic);

            if(topic.equals(COMMAND_PUBLISH)) {
                context.handler.sendEmptyMessage(DataFragment.MESSAGE_PUBLISH_INFO);
            } else {
                Message msg = new Message();
                Bundle b = new Bundle();
                b.putString("log", mqttMessage.toString());
                msg.setData(b);
                context.handler.sendMessage(msg);
            }
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

        }
    }

}

