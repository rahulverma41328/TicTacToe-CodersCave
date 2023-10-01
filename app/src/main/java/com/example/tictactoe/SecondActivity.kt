package com.example.tictactoe

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private var boxPositions = intArrayOf(0,0,0,0,0,0,0,0,0)
    private var playerTurn = 1
    private val combinationList: MutableList<IntArray> = mutableListOf()
    private var totalSelectedBoxes = 1
    private lateinit var  playerOneLayout: LinearLayout
    private lateinit var  playerTwoLayout: LinearLayout
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var img6: ImageView
    private lateinit var img7: ImageView
    private lateinit var img8: ImageView
    private lateinit var img9: ImageView

    private lateinit var  playerOneName:String
    private lateinit var playerTwoName:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        window.statusBarColor = resources.getColor(R.color.appBackground)

        val playerOne = findViewById<TextView>(R.id.player_one)
        val playerTwo = findViewById<TextView>(R.id.player_two)
        playerOneLayout = findViewById(R.id.playerOneLayout)
        playerTwoLayout = findViewById(R.id.playerTwoLayout)
        playerOneName = intent.getStringExtra("first").toString()
        playerTwoName = intent.getStringExtra("second").toString()

        playerOne.text = playerOneName
        playerTwo.text = playerTwoName
     //   Toast.makeText(this,"$playerOneName $playerTwoName",Toast.LENGTH_LONG).show()

        // box id
        img1 = findViewById(R.id.image1)
        img2 = findViewById(R.id.image2)
        img3 = findViewById(R.id.image3)
        img4 = findViewById(R.id.image4)
        img5 = findViewById(R.id.image5)
        img6 = findViewById(R.id.image6)
        img7 = findViewById(R.id.image7)
        img8 = findViewById(R.id.image8)
        img9 = findViewById(R.id.image9)

        combinationList.add(intArrayOf(0,1,2))
        combinationList.add(intArrayOf(3,4,5))
        combinationList.add(intArrayOf(6,7,8))
        combinationList.add(intArrayOf(0,3,6))
        combinationList.add(intArrayOf(1,4,7))
        combinationList.add(intArrayOf(2,5,8))
        combinationList.add(intArrayOf(2,4,6))
        combinationList.add(intArrayOf(0,4,8))

        playerOneLayout.setOnClickListener {

        }
        playerTwoLayout.setOnClickListener {
        }
        img1.setOnClickListener {
            if (isBoxSelectable(0)){
                performAction(it as ImageView,0)
            }
        }
        img2.setOnClickListener {
            if (isBoxSelectable(1)){
                performAction(it as ImageView,1)
            }
        }
        img3.setOnClickListener {
            if (isBoxSelectable(2)){
                performAction(it as ImageView,2)
            }
        }
        img4.setOnClickListener {
            if (isBoxSelectable(3)){
                performAction(it as ImageView,3)
            }
        }
        img5.setOnClickListener {
            if (isBoxSelectable(4)){
                performAction(it as ImageView,4)
            }
        }
        img6.setOnClickListener {
            if (isBoxSelectable(5)){
                performAction(it as ImageView,5)
            }
        }
        img7.setOnClickListener {
            if (isBoxSelectable(6)){
                performAction(it as ImageView,6)
            }
        }
        img8.setOnClickListener {
           if (isBoxSelectable(7)){
               performAction(it as ImageView,7)
           }
        }
        img9.setOnClickListener {
            if (isBoxSelectable(8)){
                performAction(it as ImageView,8)
            }
        }

    }
    private fun performAction(imageView: ImageView,selectBoxPosition: Int) {
        boxPositions[selectBoxPosition] = playerTurn;
        if (playerTurn==1){
            imageView.setImageResource(R.drawable.cross)
            if (checkPlayerMin()){
                val winDialog = WinDialog(this,playerOneName,this)
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else if (totalSelectedBoxes==9){
                val winDialog = WinDialog(applicationContext,"It's a draw", SecondActivity())
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else{
                changePlayerTurn(2)
                totalSelectedBoxes++
            }
        }
        else{
            imageView.setImageResource(R.drawable.circle)
            if (checkPlayerMin()){
                val winDialog = WinDialog(this,"$playerOneName won the match",
                    this
                )
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else if (selectBoxPosition == 9){
                val winDialog = WinDialog(this,"It is a draw",this)
                winDialog.setCancelable(false)
                winDialog.show()
            }
            else{
                changePlayerTurn(1)
                totalSelectedBoxes++
            }
        }
    }

    private fun changePlayerTurn(currentPlayerTurn:Int){
        playerTurn = currentPlayerTurn
        if (playerTurn == 1){
            playerOneLayout.setBackgroundResource(R.drawable.text_bg)
            playerTwoLayout.setBackgroundResource(R.drawable.toe_bg)
        }
        else{
            playerOneLayout.setBackgroundResource(R.drawable.toe_bg)
            playerTwoLayout.setBackgroundResource(R.drawable.text_bg)
        }

    }

    private fun checkPlayerMin(): Boolean{
        var response = false

        for (i in 0 until  combinationList.size){
            val combination : IntArray = combinationList[i]

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn){
                response = true
            }
        }
        return response
    }

    private fun isBoxSelectable(boxPosition: Int): Boolean{
        var response = false
        if (boxPositions[boxPosition] == 0){
            response = true
        }
        return response
    }

    public fun restartMatch(){
        boxPositions = intArrayOf(0,0,0,0,0,0,0,0,0)
        playerTurn = 1
        totalSelectedBoxes = 1
        img1.setImageResource(R.drawable.tic_bg)
        img2.setImageResource(R.drawable.tic_bg)
        img3.setImageResource(R.drawable.tic_bg)
        img4.setImageResource(R.drawable.tic_bg)
        img5.setImageResource(R.drawable.tic_bg)
        img6.setImageResource(R.drawable.tic_bg)
        img7.setImageResource(R.drawable.tic_bg)
        img8.setImageResource(R.drawable.tic_bg)
        img9.setImageResource(R.drawable.tic_bg)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}