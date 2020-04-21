package com.chenqiao.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by chenqiao on 2020/4/21.
 * e-mail : mrjctech@gmail.com
 */
class SeekBarViewModel : ViewModel(){

    val seekBarValue = MutableLiveData<Int>()

}