package com.nyandori.dailybreaddevotions

data class SecondReading(
    val second_bible_chapter: String,

    val second_readings: String
)
{
    constructor():this("",  "")
}