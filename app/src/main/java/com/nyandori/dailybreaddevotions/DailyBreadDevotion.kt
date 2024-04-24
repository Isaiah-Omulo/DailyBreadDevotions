package com.nyandori.dailybreaddevotions

data class DailyBreadDevotion(
    val first_reading: FirstReading,
    val gospel: Gospel,
    val responsorial_psalm: ResponsorialPsalmX,
    val second_reading: SecondReading,
    val song: String,
    val title: String
){
    constructor():this(FirstReading(),
        Gospel(), ResponsorialPsalmX
    (), SecondReading
    (), "","")
}