package com.example.emqx

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Homescreen : AppCompatActivity() {
    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_homescreen)


        val lineralayoutdevice1 = findViewById<LinearLayout>(R.id.lineradevice1)
        val lineralayoutdevice2 = findViewById<LinearLayout>(R.id.lineradevice2)
        val lineralayoutdevice3 = findViewById<LinearLayout>(R.id.linearlayoutdevice3)
        val lineralayoutdevice4 = findViewById<LinearLayout>(R.id.lineradevice4)
        val lineralayoutdevice5 = findViewById<LinearLayout>(R.id.lineradevice5)
        val logoutbtn = findViewById<FloatingActionButton>(R.id.logoutbtn)


        lineralayoutdevice1.setOnClickListener {
            val intent = Intent(applicationContext, BoardOne::class.java)
            startActivity(intent)
        }
        lineralayoutdevice2.setOnClickListener {
            val intent = Intent(applicationContext, Boardtwo::class.java)
            startActivity(intent)
        }
        lineralayoutdevice3.setOnClickListener {
            val intent = Intent(applicationContext, Boardthree::class.java)
            startActivity(intent)
        }
        lineralayoutdevice4.setOnClickListener {
            val intent = Intent(applicationContext, boardfour::class.java)
            startActivity(intent)
        }
        lineralayoutdevice5.setOnClickListener {
            val intent = Intent(applicationContext, boardfour::class.java)
            startActivity(intent)
        }




        logoutbtn.setOnClickListener {
            singletonInstanceOfMqttClient.disconnect()
            Toast.makeText(this, "Log out", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}