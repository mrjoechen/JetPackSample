package com.chenqiao.coroutinue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            Log.d("chenqiao launch", Thread.currentThread().name)

            val result = withContext(Dispatchers.IO){
            Log.d("chenqiao context(IO)", Thread.currentThread().name)
            getNetworkService().reposWithSuspend("0").string()
        }


            val result2 = getNetworkService().reposWithSuspend("0").string()
            tv.text = result2
        }

//        tv.text = "chenqiao"
//        val execute = getNetworkService().repos("0").execute()
//        tv.text = execute.body().toString()

    }
}
