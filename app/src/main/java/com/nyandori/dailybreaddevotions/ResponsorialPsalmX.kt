package com.nyandori.dailybreaddevotions

data class ResponsorialPsalmX(
    val bible_chapter_response: String,
    val response: String,
    val responsorial_psalm_reading: String
)
{
    constructor():this("","","")
}