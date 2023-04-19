package com.example.paytmintegration.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class viewmodel: ViewModel() {
    private val _price=MutableStateFlow("")
    val price:StateFlow<String>
    get()=_price.asStateFlow()
    //update price field
    fun updatePriceField(price:String){
        _price.value=price
    }

}