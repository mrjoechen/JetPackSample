package com.chenqiao.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




/**
 * Created by chenqiao on 2019-12-24.
 * e-mail : mrjctech@gmail.com
 */
class NameViewModel : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val nameListData: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }


    // Rest of the ViewModel...
}
