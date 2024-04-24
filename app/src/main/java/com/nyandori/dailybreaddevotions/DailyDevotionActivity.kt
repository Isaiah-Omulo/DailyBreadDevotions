package com.nyandori.dailybreaddevotions

import android.R
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.nyandori.dailybreaddevotions.databinding.ActivityDailyDevotionBinding


class DailyDevotionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDailyDevotionBinding
    companion object{
        var dailyDevotion:DailyBreadDevotion = DailyBreadDevotion()
    }

    private var mp: MediaPlayer? = null
    private var wasPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyDevotionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("tag", dailyDevotion.toString())
        binding.devotionTitle.text = dailyDevotion.title
        binding.firstReadings.text = dailyDevotion.first_reading.first_readings
        binding.firstReadingBibleChapter.text = dailyDevotion.first_reading.first_bible_chapter
        binding.voicePlayerView.setAudio(dailyDevotion.song)
        //binding.Readings.text = dailyDevotion.description

        binding.responsorialPsalm.setOnClickListener {
            ResponsorialPsalm.dailyDevotion = dailyDevotion
            val intent = Intent(this, ResponsorialPsalm::class.java)
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            binding.voicePlayerView.onStop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.stop.setOnClickListener {
            binding.voicePlayerView.onStop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
         binding.voicePlayerView.imgPlay.setOnClickListener (
             binding.voicePlayerView.imgPlayClickListener)





        binding.voicePlayerView.imgPause.setOnClickListener {
            binding.voicePlayerView.onPause()
        }






    }

}