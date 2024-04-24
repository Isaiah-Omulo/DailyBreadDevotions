package com.nyandori.dailybreaddevotions

data class FirstReading(

    val first_bible_chapter: String,
    val first_readings: String
){
    constructor():this("", "")
}