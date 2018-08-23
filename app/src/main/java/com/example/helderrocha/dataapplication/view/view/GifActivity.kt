package com.example.helderrocha.dataapplication.view.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.helderrocha.dataapplication.R
import kotlinx.android.synthetic.main.gif_activity.*

class GifActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gif_activity)
        val number = intent.getStringExtra("number")
        if(number.equals("1")){
            Glide.with(this)
                    .asGif()
                    .load("https://media.giphy.com/media/1AvgIR95vq9HO/giphy.gif")
                    .into(imageViewGif)
        }else{
            Glide.with(this)
                    .asGif()
                    .load("https://media.giphy.com/media/5RaJN7aCkmC6A/giphy.gif")
                    .into(imageViewGif)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
