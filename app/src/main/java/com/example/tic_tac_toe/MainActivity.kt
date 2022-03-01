package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var gameActive: Boolean = true;
    var gameState = Array(9) { 2 }

    var activePlayer = 0;

    val winPositions = arrayOf(
        intArrayOf(0, 1, 2), intArrayOf(3, 4, 5), intArrayOf(6, 7, 8), intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7), intArrayOf(2, 5, 8), intArrayOf(0, 4, 8), intArrayOf(2, 4, 6)
    );

    var counter = 0;
    @SuppressLint("SetTextI18n")
    fun playerTap(view: View) {
        val img = view as ImageView
        val tappedImage = img.tag.toString().toInt()
        if (!gameActive) {
            gameReset(view);
        }

        if (gameState[tappedImage] == 2) {
            counter++;
            if (counter == 9) {
                gameActive = false;
            }
            gameState[tappedImage] = activePlayer;

            img.translationZ = 10F

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1
            } else {
                img.setImageResource(R.drawable.o)
                activePlayer = 0
            }
        }
        var flag = 0;

        for (item in winPositions) {
            if (gameState[item[0]] == gameState[item[1]] && gameState[item[1]] == gameState[item[2]] && gameState[item[0]] != 2) {
                flag=1

                gameActive=false;

                if (gameState[item[0]]==0){
                    findViewById<TextView>(R.id.textView).text = "X is Winner"

                }
                else{
                    findViewById<TextView>(R.id.textView).text = "O is Winner"

                }
            }
            if(counter==9 && flag==0){
                findViewById<TextView>(R.id.textView).text = "Match Drawn"


            }
        }
    }


     fun gameReset(view: View) {
        findViewById<TextView>(R.id.textView).text = "TIC TAC TOE"
        gameActive = true
        counter=0;
        activePlayer = 0
        for (i in 0 until 9) {
            gameState[i] = 2
        }
        findViewById<ImageView>(R.id.imageView13).setImageResource(0);
        findViewById<ImageView>(R.id.imageView14).setImageResource(0);
        findViewById<ImageView>(R.id.imageView15).setImageResource(0);
        findViewById<ImageView>(R.id.imageView16).setImageResource(0);
        findViewById<ImageView>(R.id.imageView17).setImageResource(0);
        findViewById<ImageView>(R.id.imageView18).setImageResource(0);
        findViewById<ImageView>(R.id.imageView19).setImageResource(0);
        findViewById<ImageView>(R.id.imageView20).setImageResource(0);
        findViewById<ImageView>(R.id.imageView21).setImageResource(0);
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}