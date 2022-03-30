package com.example.historicalplaces

object Repository {
    var sentence1 = "تغییرات بیرونی همیشه با یک تغییر درونی در نگرش آغاز می شود.\n\n“آلبرت انیشتین”"
    var sentence2 = "ذهن، هرگز از یادگیری خسته نمی شود\n\n“لئوناردو داوینچی”"
    var sentence3 = "دانش، ميراثى گرانبها، و آداب، زيورهاى هميشه تازه، و انديشه، آيينه اى شفاف است.\n\n امام علی(ع) "
    var sentence4 ="صدقه دادن دارويى ثمر بخش است، و كردار بندگان در دنيا، فردا در پيش روى آنان جلوه گر است. \n\n امام علی(ع) "
    var sentence5 = "چون نشانه هاى نعمت پروردگار آشكار شد، با ناسپاسى نعمت ها را از خود دور نسازيد.\n\n امام علی(ع)"
    var sentence6 ="هرچه فکر شما بزرگ باشد به همان اندازه بیشتر به افکار دیگران احترام می گذارید. \n\n بلز پاسکال"
    var sentence7 ="چالش ها چیزی هستند که زندگی را جذاب می کنند و غلبه بر آن ها چیزی است که زندگی را معنادار می کند\n\n“جاشوا مارین”"
    var sentence8 ="كسى كه كردارش او را به جايى نرساند، افتخارات خاندانش او را به جايى نخواهد رسانيد.\n\n امام علی(ع)"
    var sentenceList = arrayListOf(sentence1, sentence2, sentence3, sentence4, sentence5, sentence6, sentence7, sentence8)
    fun randomsentence():String{
        return sentenceList.random()
    }
}