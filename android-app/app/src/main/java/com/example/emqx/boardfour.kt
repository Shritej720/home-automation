package com.example.emqx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class boardfour : AppCompatActivity() {
    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_boardfour)

        val usertopic_boardfour = findViewById<EditText>(R.id.board_four_user_topic)
//        val connect_boardfour = findViewById<Button>(R.id.board4_connect)

        val onone_boardfour = findViewById<TextView>(R.id.onone_boardfour)
        val offone_boardfour = findViewById<TextView>(R.id.offone_boardfour)

        val ontwo_boardfour = findViewById<TextView>(R.id.ontwo_boardfour)
        val offtwo_boardfour = findViewById<TextView>(R.id.offtwo_boardfour)

        val onthree_boardfour = findViewById<TextView>(R.id.onthree_boardfour)
        val offthree_boardfour = findViewById<TextView>(R.id.offthree_boardfour)

        val onfour_boardfour = findViewById<TextView>(R.id.onfour_boardfour)
        val offfour_boardfour = findViewById<TextView>(R.id.offfour_boardfour)


        onone_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "0",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offone_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "1",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        ontwo_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "2",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offtwo_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "3",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        onthree_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "4",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offthree_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "5",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        onfour_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "6",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offfour_boardfour.setOnClickListener {
            if (usertopic_boardfour.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usertopic_boardfour.setError("Please enter topic");

            } else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardfour.text.toString(),
                    "7",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }


    }
}