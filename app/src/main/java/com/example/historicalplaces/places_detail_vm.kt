package com.example.historicalplaces

import androidx.lifecycle.ViewModel

data class place(var pictureURL:String, var name: Int, var explanation:Int)
class places_detail_vm:ViewModel() {
    var historicalPlacesList = arrayListOf<place>()
    var place1 = place("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcdSGphxGM4JUulkhcCsU4KuYxwIJsJ5oOng&usqp=CAU",R.string.firstPlace)
    init {
        historicalPlacesList.add()
    }

}