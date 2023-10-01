package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.appBackground)
        val firstPlayer = findViewById<EditText>(R.id.first_player)
        val secondPlayer = findViewById<EditText>(R.id.second_player)
        val startBtn = findViewById<AppCompatButton>(R.id.start_btn)

        var firstPlayerName: String
        var secondPlayerName: String


        startBtn.setOnClickListener {
            firstPlayerName = firstPlayer.text.toString()
            secondPlayerName = secondPlayer.text.toString()
            if (firstPlayerName.isEmpty() || secondPlayerName.isEmpty()){
                Toast.makeText(this,"Enter player Name",Toast.LENGTH_LONG).show()
            }
            else{
               // Toast.makeText(this,"$firstPlayerName $secondPlayerName",Toast.LENGTH_LONG).show()
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("first",firstPlayerName)
                intent.putExtra("second",secondPlayerName)
                startActivity(intent)
                finish()
            }
        }
    }
}