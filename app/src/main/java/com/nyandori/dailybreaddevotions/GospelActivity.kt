package com.nyandori.dailybreaddevotions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nyandori.dailybreaddevotions.databinding.ActivityGospelBinding

class GospelActivity : AppCompatActivity() {
    lateinit var binding:ActivityGospelBinding
    companion object{
        var dailyDevotion:DailyBreadDevotion = DailyBreadDevotion()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGospelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bibleGospelChapter.text = dailyDevotion.gospel.bible_gospel_chapter
        binding.gospelAcclamation.text = dailyDevotion.gospel.gospel_acclamation
        binding.gospelReadings.text = dailyDevotion.gospel.gospel_readings
        binding.gospelAcclamationChapter.text = dailyDevotion.gospel.gospel_acclamation_chapter

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DailyDevotionActivity::class.java)
            startActivity(intent)
        }
        binding.home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}