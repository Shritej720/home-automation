package com.example.emqx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class BoardOne : AppCompatActivity() {

    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_board_one)

        val boardOneUserTopic = findViewById<EditText>(R.id.board_one_user_topic)
        val btnOn1 = findViewById<TextView>(R.id.on1)
        val btnOff1 = findViewById<TextView>(R.id.off1)
        val btnOn2 = findViewById<TextView>(R.id.on2)
        val btnOff2 = findViewById<TextView>(R.id.off2)
        val pleasenote = findViewById<TextView>(R.id.noteone)
        val errorbutton = findViewById<Button>(R.id.errorbutton)
        errorbutton.setOnClickListener(View.OnClickListener {
            pleasenote.setText("Please note, Topic is case sensitive and it take value as a string \\n if your topic is correct only then it can connect to the hardware \\n Please be careful while adding topic")
        })



        btnOn1.setOnClickListener {
            if (boardOneUserTopic.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                boardOneUserTopic.setError("Please enter Topic")
            } else {
                singletonInstanceOfMqttClient.publish(
                    boardOneUserTopic.text.toString(),
                    "0",
                    1,
                    false
                )
                Toast.makeText(applicationContext, "Message send to"+boardOneUserTopic.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("TAG", "btn on1");
            }
        }
        btnOff1.setOnClickListener {
            if (boardOneUserTopic.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                boardOneUserTopic.setError("Please enter Topic")
            } else {
                singletonInstanceOfMqttClient.publish(
                    boardOneUserTopic.text.toString(),
                    "1",
                    1,
                    false
                )
                Toast.makeText(applicationContext, "Message send to"+boardOneUserTopic.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("TAG", "btn off1");
            }
        }
        btnOn2.setOnClickListener {
            if (boardOneUserTopic.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                boardOneUserTopic.setError("Please enter Topic")

            } else {


                singletonInstanceOfMqttClient.publish(
                    boardOneUserTopic.text.toString(),
                    "3",
                    1,
                    false
                )
                Toast.makeText(applicationContext, "Message send to"+boardOneUserTopic.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("TAG", "btn on2")
            }
        }
        btnOff2.setOnClickListener {
            if (boardOneUserTopic.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                boardOneUserTopic.setError("Please enter Topic")

            } else {
                singletonInstanceOfMqttClient.publish(
                    boardOneUserTopic.text.toString(),
                    "2",
                    1,
                    false
                )
                Toast.makeText(applicationContext, "Message send to"+boardOneUserTopic.text.toString(), Toast.LENGTH_SHORT).show()
                Log.d("TAG", "btn off2")
            }
        }

    }
}