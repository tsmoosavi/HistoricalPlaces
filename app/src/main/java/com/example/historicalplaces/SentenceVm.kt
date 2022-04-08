package com.example.historicalplaces

import androidx.lifecycle.ViewModel

class SentenceVm: ViewModel(){
    var listOfSentence = Repository.sentenceList
    fun randomsentence():String{
        return listOfSentence.random()
    }
}