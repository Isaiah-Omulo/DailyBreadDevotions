package com.nyandori.dailybreaddevotions

data class DevotionModel(
    val daily_bread_devotion: DailyBreadDevotion,
    val date: String,

){
    constructor():this(DailyBreadDevotion(),"",)
}