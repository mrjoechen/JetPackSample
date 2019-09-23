package com.chenqiao.demo;

import android.util.Log;

public class MyPresenter implements IPresenter {
    private static final String TAG = "test";

    @Override
    public void onResume() {
        Log.d(TAG, "Lifecycle call onResume");
    }

    @Override
    public void onPause() {
        Log.d(TAG, "Lifecycle call onPause");
    }
}
