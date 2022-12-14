package com.example.animationfinal

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

val sRandom: Random = Random()

@SuppressLint("StaticFieldLeak")
private  lateinit var imageView: ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        spinBottle()
    }
    private fun spinBottle() {
        val imageView: ImageView = findViewById(R.id.imageView)

        val angle: Int = sRandom.nextInt(3600 - 360) + 360
        // Центр вращения
        val pivotX: Int = imageView.getWidth() / 2
        val pivotY: Int = imageView.getHeight() / 2
        val animation: Animation = RotateAnimation(
            (if (lastAngle === -1) 0 else lastAngle).toFloat(),
            angle.toFloat(), pivotX.toFloat(), pivotY.toFloat()
        )
        lastAngle = angle
        animation.duration = 5500
        animation.fillAfter = true
        animation.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(animation)
    }
}