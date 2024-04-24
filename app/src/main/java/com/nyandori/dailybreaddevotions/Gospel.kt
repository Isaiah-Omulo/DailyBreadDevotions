package com.nyandori.dailybreaddevotions

data class Gospel(
    val bible_gospel_chapter: String,
    val gospel_acclamation: String,
    val gospel_acclamation_chapter: String,
    val gospel_readings: String
){
    constructor(): this( "","","",
        "")
}