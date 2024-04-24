package com.nyandori.dailybreaddevotions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nyandori.dailybreaddevotions.databinding.ActivityResponsorialPsalmBinding

class ResponsorialPsalm : AppCompatActivity() {
    lateinit var binding: ActivityResponsorialPsalmBinding
    companion object{
        var dailyDevotion:DailyBreadDevotion = DailyBreadDevotion()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResponsorialPsalmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (dailyDevotion.second_reading.second_bible_chapter.equals("no")){
            binding.secondReading.text = "GOSPEL"
        }
       binding.responsorialPsalmReading.text = dailyDevotion.responsorial_psalm.responsorial_psalm_reading
        binding.bibleChapterResponse.text = dailyDevotion.responsorial_psalm.bible_chapter_response
        binding.response.text = dailyDevotion.responsorial_psalm.response
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, DailyDevotionActivity::class.java)
            startActivity(intent)
        }
        binding.secondReading.setOnClickListener {
            if (binding.secondReading.text.equals("GOSPEL")){
                GospelActivity.dailyDevotion = dailyDevotion
                val intent = Intent(this, GospelActivity::class.java)
                startActivity(intent)
            }else{
                SecondReadingActivity.dailyDevotion = dailyDevotion
                val intent = Intent(this, SecondReadingActivity::class.java)
                startActivity(intent)
            }
        }


    }
}