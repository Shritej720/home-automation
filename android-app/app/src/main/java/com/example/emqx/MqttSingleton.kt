package com.example.emqx

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*
import java.util.concurrent.FutureTask


internal object MqttSingleton {

    var TAG: String = "SINGLETON";

    private lateinit var mqttClient: MqttAndroidClient

    private var instance: MqttSingleton? = null

    private fun MqttSingleton() {}

    @Synchronized
    private fun createInstance() {
        if (instance == null) {
            instance = MqttSingleton
        }
    }

    fun getInstance(): MqttSingleton? {
        if (instance == null) createInstance()
        return instance
    }


    init {

        Log.d(TAG, "Singleton class invoked.")
    }

    fun setMqttClientConnectionInstance(mqttClient : MqttAndroidClient){
        this.mqttClient = mqttClient;
    }

    fun getMqttClientConnectionInstance(): MqttAndroidClient{
        return this.mqttClient;
    }

    fun setConnectedStatus(value: Boolean) {
        this.connnectedFlag = value
    }

    fun getConnectedStatus(): Any? {
        return this.connnectedFlag
    }

    fun customCallback() {
        Log.d(TAG, "data from connect method")
    }

    private var connnectedFlag: Any? = null;

    suspend fun connect(
        context: MainActivity,
        username: EditText,
        password: EditText,
        recieve: TextView
    ): Any? {

        Log.d(TAG, "Connect method was called")
        // emq x server url
        val serverURI = "tcp://wcf75e2b.us-east-1.emqx.cloud:15189"
        mqttClient = MqttAndroidClient(context, serverURI, "")
        mqttClient.setCallback(object : MqttCallback {
            override fun messageArrived(topic: String?, message: MqttMessage?) {
                recieve.setText(message.toString())
                Log.d(TAG, "Receive message: ${message.toString()} from topic: $topic")

            }

            override fun connectionLost(cause: Throwable?) {
                Log.d(TAG, "Connection lost ${cause.toString()}")

            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {

            }
        })
//         mqtt connection optins
        val options = MqttConnectOptions()

//        pass username and passwor to options
        Log.d(TAG, username.text.toString())
        Log.d(TAG, password.text.toString())

        options.userName = username.text.toString();
        options.password = password.text.toString().toCharArray();

        try {

            mqttClient.connect(options, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Connection success")
                    Log.d(TAG, asyncActionToken.toString())
                    setConnectedStatus(true)
                }
                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, exception.toString())
                    Log.d(TAG, "Connection failure")
                    setConnectedStatus(false)
                }
            })
                delay(5000L)
          return getConnectedStatus()
//            return true
        } catch (e: MqttException) {
            return e.printStackTrace()
        }
    }

    fun isClientConnected ( ):Boolean {
        return mqttClient.isConnected
    }

    //    to subsribe to a particular topic
    fun subscribe(topic: String, qos: Int = 1) {
        try {

            mqttClient.subscribe(topic, qos, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Subscribed to $topic")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {

                    Log.d(TAG, "Failed to subscribe $topic")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun publish(topic: String, msg: String, qos: Int = 1, retained: Boolean = false) {
        try {
            val message = MqttMessage()
            message.payload = msg.toByteArray()
            message.qos = qos
            message.isRetained = retained
            mqttClient.publish(topic, message, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "$msg published to $topic")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Failed to publish $msg to $topic")


                }


            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun disconnect() {
        try {
            mqttClient.disconnect(null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken?) {
                    Log.d(TAG, "Disconnected")
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, "Failed to disconnect")
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }
}