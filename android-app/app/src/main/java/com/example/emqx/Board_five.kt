package com.example.emqx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Board_five : AppCompatActivity() {
    // created singleton for mqtt client
    private val singletonInstanceOfMqttClient = MqttSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove actionbar
        supportActionBar?.hide()
        setContentView(R.layout.activity_board_five)

        val usrtopic_five = findViewById<EditText>(R.id.board_five_user_topic)
        val notefive = findViewById<EditText>(R.id.notefive)

        val onone_boardfive = findViewById<TextView>(R.id.onone_boardfive)
        val offone_boardfive = findViewById<TextView>(R.id.offone_boardfive)

        val ontwo_boardfive = findViewById<TextView>(R.id.ontwo_boardfive)
        val offtwo_boardfive = findViewById<TextView>(R.id.offtwo_boardfive)

        val onthree_boardfive = findViewById<TextView>(R.id.onthree_boardfive)
        val offthree_boardfive = findViewById<TextView>(R.id.offthree_boardfive)

        val onfour_boardfive = findViewById<TextView>(R.id.onfour_boardfive)
        val offfour_boardfive = findViewById<TextView>(R.id.offfour_boardfive)

        onone_boardfive.setOnClickListener {
            if (usrtopic_five.text.toString().trim().length == 0) {
                val toast =
                    Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                        .show()
                usrtopic_five.setError("please enter topic");
            } else {
                singletonInstanceOfMqttClient.publish(
                    usrtopic_five.text.toString(),
                    "0",
                    1,
                    false
                )
                Log.d("TAG", "btn on1");
            }
        }

            offone_boardfive.setOnClickListener {
                if (usrtopic_five.text.toString().trim().length == 0) {
                    val toast =
                        Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                            .show()
                    usrtopic_five.setError("please enter topic");
                } else {
                    singletonInstanceOfMqttClient.publish(
                        usrtopic_five.text.toString(),
                        "0",
                        1,
                        false
                    )
                    Log.d("TAG", "btn on1");
                }
            }
                ontwo_boardfive.setOnClickListener {
                    if (usrtopic_five.text.toString().trim().length == 0) {
                        val toast =
                            Toast.makeText(applicationContext, "Please add topic", Toast.LENGTH_SHORT)
                                .show()
                        usrtopic_five.setError("please enter topic");
                    } else {
                        singletonInstanceOfMqttClient.publish(
                            usrtopic_five.text.toString(),
                            "0",
                            1,
                            false
                        )
                        Log.d("TAG", "btn on1");
                    }

        }
                offtwo_boardfive.setOnClickListener {
                    if (usrtopic_five.text.toString().trim().length == 0) {
                        val toast =
                            Toast.makeText(
                                applicationContext,
                                "Please add topic",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        usrtopic_five.setError("please enter topic");
                    } else {
                        singletonInstanceOfMqttClient.publish(
                            usrtopic_five.text.toString(),
                            "0",
                            1,
                            false
                        )
                        Log.d("TAG", "btn on1");
                    }
                }
                    onthree_boardfive.setOnClickListener {
                        if (usrtopic_five.text.toString().trim().length == 0) {
                            val toast =
                                Toast.makeText(
                                    applicationContext,
                                    "Please add topic",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            usrtopic_five.setError("please enter topic");
                        } else {
                            singletonInstanceOfMqttClient.publish(
                                usrtopic_five.text.toString(),
                                "0",
                                1,
                                false
                            )
                            Log.d("TAG", "btn on1");
                        }
                    }

                        offthree_boardfive.setOnClickListener {
                            if (usrtopic_five.text.toString().trim().length == 0) {
                                val toast =
                                    Toast.makeText(
                                        applicationContext,
                                        "Please add topic",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                usrtopic_five.setError("please enter topic");
                            } else {
                                singletonInstanceOfMqttClient.publish(
                                    usrtopic_five.text.toString(),
                                    "0",
                                    1,
                                    false
                                )
                                Log.d("TAG", "btn on1");
                            }
                        }


                            onfour_boardfive.setOnClickListener {
                                if (usrtopic_five.text.toString().trim().length == 0) {
                                    val toast =
                                        Toast.makeText(
                                            applicationContext,
                                            "Please add topic",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    usrtopic_five.setError("please enter topic");
                                } else {
                                    singletonInstanceOfMqttClient.publish(
                                        usrtopic_five.text.toString(),
                                        "0",
                                        1,
                                        false
                                    )
                                    Log.d("TAG", "btn on1");
                                }
                            }
                                offfour_boardfive.setOnClickListener {
                                    if (usrtopic_five.text.toString().trim().length == 0) {
                                        val toast =
                                            Toast.makeText(
                                                applicationContext,
                                                "Please add topic",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        usrtopic_five.setError("please enter topic");
                                    } else {
                                        singletonInstanceOfMqttClient.publish(
                                            usrtopic_five.text.toString(),
                                            "0",
                                            1,
                                            false
                                        )
                                        Log.d("TAG", "btn on1");
                                    }
                                }
    }
}