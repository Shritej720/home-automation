package com.example.emqx

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*
import java.lang.Exception
import kotlin.coroutines.*


open class MainActivity : AppCompatActivity() {
    private lateinit var mqttClient: MqttAndroidClient

    //importaint line
    private val singletonInstanceOfMqttClient = MqttSingleton


    private var TAG = "MAIN";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //remove actionbar
        supportActionBar?.hide()
        //  get reference if ui element
        val usernameTextBox = findViewById<EditText>(R.id.username)
        val passwordTextBox = findViewById<EditText>(R.id.password)
        val receiveTextBox = findViewById<TextView>(R.id.receive)
        val sign_in = findViewById<Button>(R.id.Sign_in)
        val LottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie)
        val pleasenote = findViewById<Button>(R.id.pleasenote)

        pleasenote.setOnClickListener(View.OnClickListener {
            receiveTextBox.setText(" Please log in with a credentials provided by EMQ x ");
        })

        Log.d(TAG, "$singletonInstanceOfMqttClient =============")

        val useredit = usernameTextBox.text.toString();
        val passedit = passwordTextBox.text.toString();

        sign_in.setOnClickListener {
            if (usernameTextBox.text.toString().trim().length == 0) {
                Toast.makeText(
                    applicationContext,
                    "please enter username & password ",
                    Toast.LENGTH_SHORT
                )
                    .show()
                usernameTextBox.setError("This value can not be empty");
            }
            else if (passwordTextBox.text.toString().trim().length == 0){
                Toast.makeText(
                    applicationContext,
                    "please enter username & password ",
                    Toast.LENGTH_SHORT
                )
                    .show()
                passwordTextBox.setError("This value can not be empty");
            }
            else  {


                try {
                    // connect to mqtt server
                    connect(this, usernameTextBox, passwordTextBox, receiveTextBox);

                } catch (ex: Exception) {

                    Log.d(TAG, "$ex Exception occured")
                }

            }

        }
    }

    fun connect(context: MainActivity, username: EditText, password: EditText, recieve: TextView) {
//        emq x server url
        val serverURI = "tcp://wcf75e2b.us-east-1.emqx.cloud:15189"
        mqttClient = MqttAndroidClient(context, serverURI, "shritej_android")
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
                    Toast.makeText(
                        context,
                        "please wait",
                        Toast.LENGTH_SHORT
                    ).show()

                    // on success set the mqtt clinet object to singleton
                    singletonInstanceOfMqttClient.setMqttClientConnectionInstance(mqttClient);

                    // and redirect to other screen
                    val homeScreenIntent = Intent(applicationContext, Homescreen::class.java)
                    startActivity(homeScreenIntent)
                }

                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                    Log.d(TAG, exception.toString())
                    Log.d(TAG, "Connection failure")
                    Toast.makeText(
                        context,
                        "There is a problem with your network or your id & password is wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }


    override fun onPause() {
        super.onPause()
        Log.d("TAG", "OnPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "Onstop")


    }

}
