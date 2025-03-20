package com.shu.complocaldemo.viemodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CountVieModel  : ViewModel() {

    var customerCount by mutableIntStateOf(0)

    fun increaseCount() {
        customerCount++
    }
}