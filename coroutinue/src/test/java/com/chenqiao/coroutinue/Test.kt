package com.chenqiao.coroutinue

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import retrofit2.*

/**
 * Created by chenqiao on 2020/4/27.
 * e-mail : mrjctech@gmail.com
 */

fun main() {

//    GlobalScope.launch {
//        log("chenqiao")
//        log(getNetworkService().reposRaw("mrjoechen").string())
//    }

    test()
}


fun test() = runBlocking {

    log("chenqiao")


//    getNetworkService().clientList("0", "20").enqueue(object : Callback<ResponseBody>{
//        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//
//            t.printStackTrace()
//        }
//
//        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//            log(response.body()!!.string())
//        }
//
//
//    })


//    getNetworkService().getclient("3").enqueue(object : Callback<ResponseBody>{
//        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//
//            t.printStackTrace()
//        }
//
//        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//            log(response.body()!!.string())
//        }
//
//
//    })

    getNetworkService().hostlist("", 0, 20).enqueue(object : Callback<ResponseBody>{
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            t.printStackTrace()
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

            log(response.body()!!.string())
        }


    })
}