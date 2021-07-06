package com.example.emqx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class Boardtwo : AppCompatActivity() {
    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_boardtwo)
        val relative = findViewById<RelativeLayout>(R.id.relativelayout_boardtwo)
        val add_topic = findViewById<EditText>(R.id.board_two_user_topic)

//        val connect_topic = findViewById<Button>(R.id.board2_connect)
        val onone_boardtwo = findViewById<TextView>(R.id.onone_boardtwo)
        val offone_boardtwo = findViewById<TextView>(R.id.offone_boardtwo)
        val ontwo_boardtwo = findViewById<TextView>(R.id.ontwo_boardtwo)
        val offtwo_boardtwo = findViewById<TextView>(R.id.offtwo_boardtwo)

        onone_boardtwo.setOnClickListener {
            if (add_topic.text.toString().trim().length == 0) {
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                add_topic.setError("Please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    add_topic.text.toString(),
                    "0",
                    1,
                    false
                )
                Log.d("TAG", "button clicked")
            }


        }
        offone_boardtwo.setOnClickListener {
            if (add_topic.text.toString().trim().length == 0) {
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                add_topic.setError("Please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    add_topic.text.toString(),
                    "1",
                    1,
                    false
                )
                Log.d("TAG", "button clicked")
            }


        }
        ontwo_boardtwo.setOnClickListener {
            if (add_topic.text.toString().trim().length == 0) {
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                add_topic.setError("Please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    add_topic.text.toString(),
                    "2",
                    1,
                    false
                )
                Log.d("TAG", "button clicked")
            }

        }
        offtwo_boardtwo.setOnClickListener {

            if (add_topic.text.toString().trim().length == 0) {
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                add_topic.setError("Please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    add_topic.text.toString(),
                    "3",
                    1,
                    false
                )
                Log.d("TAG", "button clicked")
            }
        }
    }
}