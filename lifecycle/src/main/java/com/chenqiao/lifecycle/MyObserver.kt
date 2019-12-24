package com.chenqiao.lifecycle


import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


class MyObserver : LifecycleObserver {

    private val TAG = "MyObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Log.d(TAG, "Lifecycle call onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        Log.d(TAG, "Lifecycle call onPause")
    }
}
