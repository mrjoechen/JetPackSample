package com.chenqiao.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.chenqiao.sample.data.model.User
import com.chenqiao.sample.net.retrofit.GithubServices
import com.chenqiao.sample.net.retrofit.HttpRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userinfo = HttpRetrofit.getService(GithubServices::class.java).userinfo("mrjoechen")
        userinfo.enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network error!", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){

                }
            }

        })
    }
}
