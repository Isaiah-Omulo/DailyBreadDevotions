package com.nyandori.dailybreaddevotions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nyandori.dailybreaddevotions.databinding.ActivitySecondReadingBinding

class SecondReadingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondReadingBinding
    companion object{
        var dailyDevotion:DailyBreadDevotion = DailyBreadDevotion()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondReadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.secondBibleChapter.text = dailyDevotion.second_reading.second_bible_chapter
        binding.SecondReadings.text = dailyDevotion.second_reading.second_readings


        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DailyDevotionActivity::class.java)
            startActivity(intent)
        }
        binding.Gospel.setOnClickListener {
            GospelActivity.dailyDevotion = ResponsorialPsalm.dailyDevotion
            val intent = Intent(this, GospelActivity::class.java)
            startActivity(intent)
        }
    }
}