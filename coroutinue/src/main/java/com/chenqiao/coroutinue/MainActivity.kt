package com.chenqiao.coroutinue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onResume() {
        super.onResume()


        CoroutineScope(Dispatchers.Main).launch{

            val result = withContext(Dispatchers.IO){
                getNetworkService().repos("0").string()
            }
            tv.setText(result)
        }

    }
}
