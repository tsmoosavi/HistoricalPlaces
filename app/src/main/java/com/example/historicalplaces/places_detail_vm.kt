package com.example.historicalplaces

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Place(var pictureURL:String, var name: Int, var explanation:Int):Parcelable
class placesDetailVm:ViewModel() {
    var numberOfViews = 6
    var historicalPlacesList = arrayListOf<Place>()
    var place1 = Place("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcdSGphxGM4JUulkhcCsU4KuYxwIJsJ5oOng&usqp=CAU",R.string.firstPlace,R.string.firstDetail)
    var place2 = Place("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPWpEtc4bJm2AmjD9ZY9zEtRz5YXJxB-voZQ&usqp=CAU",R.string.bam,R.string.secondDetail)
    var place3 = Place("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfoAez9VXW5YqYe6vlAILHRKHw4ajkU5qjdQ&usqp=CAU",R.string.hegmatane,R.string.thirdDetail)
    var place4 = Place("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQohoAxiP5fZ4qURf4wcTcjkHIgzb_U4DxMWw&usqp=CAU",R.string.jamshid,R.string.forthDetail)
    init {
        historicalPlacesList.add(place1)
        historicalPlacesList.add(place2)
        historicalPlacesList.add(place3)
        historicalPlacesList.add(place4)
    }
}