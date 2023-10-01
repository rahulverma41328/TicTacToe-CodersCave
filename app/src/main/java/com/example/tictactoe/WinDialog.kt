package com.example.tictactoe

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WinDialog(
    context: Context,
    private val message: String,
    private val secondActivity: SecondActivity
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.win_dialog_layout)

        var messageTxt = findViewById<TextView>(R.id.message_txt)
        val startAgainBtn = findViewById<Button>(R.id.start_again_btn)

        messageTxt.text = message

        startAgainBtn.setOnClickListener {
            secondActivity.restartMatch()
            dismiss()
        }
    }
}