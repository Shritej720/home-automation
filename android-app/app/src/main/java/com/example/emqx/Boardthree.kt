package com.example.emqx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class Boardthree : AppCompatActivity() {
    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_boardthree)

        val usertopic_boardthree = findViewById<EditText>(R.id.board_three_user_topic)
//        val connect_boardthree = findViewById<Button>(R.id.board3_connect)
        val relativethree = findViewById<RelativeLayout>(R.id.relativelayout_boardthree)
        val onone_boardthreee = findViewById<TextView>(R.id.onone_boardthree)
        val offone_boardthree = findViewById<TextView>(R.id.offone_boardthree)
        val ontwo_boardthree = findViewById<TextView>(R.id.ontwo_boardthree)
        val offtwo_boardthree = findViewById<TextView>(R.id.offtwo_boardthree)
        val onthree_boardthree = findViewById<TextView>(R.id.onthree_boardthree)
        val offthree_boardthree = findViewById<TextView>(R.id.offthree_boardthree)
        val onfour_boardthree = findViewById<TextView>(R.id.onfour_boardthree)
        val offfour_boardthree = findViewById<TextView>(R.id.offfour_boardthree)

        onone_boardthreee.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "0",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }

        offone_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");

            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "1",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        ontwo_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "2",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offtwo_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "3",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        onthree_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "4",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offthree_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "5",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        onfour_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "6",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }
        offfour_boardthree.setOnClickListener {
            if (usertopic_boardthree.text.toString().trim().length==0){
                Toast.makeText(applicationContext, "Please enter topic", Toast.LENGTH_SHORT).show()
                usertopic_boardthree.setError("Please enter topic");
            }
            else {
                singletonInstanceOfMqttClient.publish(
                    usertopic_boardthree.text.toString(),
                    "7",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }

        }

    }
}