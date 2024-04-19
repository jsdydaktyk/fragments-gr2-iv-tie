package com.example.myfragments.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


//ViewModel PRZECHOWYWAĆ I ZARZĄDZAĆ danymi związanymi z interfejsem użytkownika
class SharedViewModel : ViewModel(){

    // LiveData - informuje zarejestrowane komponenty, o tym, że
    // musza zaktualizować swój interfejs
    private val _msg = MutableLiveData<String>()
    val selectedMessage: LiveData<String> = _msg

    fun setMessage(msg: String){
        _msg.value = msg
        //Log.i("viewmodel", "${selectedMessage.value}")
    }

//    fun getMessage(): LiveData<String>{
//        return selectedMessage
//    }

}