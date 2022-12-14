package com.example.animationfinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


@SuppressLint("StaticFieldLeak")
lateinit var  textViewTimer:TextView
@SuppressLint("StaticFieldLeak")
private lateinit var imageView: ImageView
var lastAngle = -1
class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinBottle();
        startTimeCounter()
    }

    fun startTimeCounter() {
        val countTime: TextView = findViewById(R.id.textViewTimer)
        object : CountDownTimer(3700, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.text = counter.toString()
                counter++
            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }
        }.start()
    }
    private fun spinBottle() {
        val imageView: ImageView = findViewById(R.id.imageView)

        val rotate = RotateAnimation(
            0F, 560F,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        )

        rotate.duration = 4000
        rotate.repeatCount = Animation.INFINITE
        imageView.setAnimation(rotate)
    }
}