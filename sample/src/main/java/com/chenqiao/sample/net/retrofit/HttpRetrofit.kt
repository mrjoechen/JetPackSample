package com.chenqiao.sample.net.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by chenqiao on 2019-12-26.
 * e-mail : mrjctech@gmail.com
 */
class HttpRetrofit {

    companion object {

        private val BASE_URL = "https://api.github.com/"

        var connectTimeout = 10 * 1000L
        var readTimeout = 10 * 1000L

        private var client = OkHttpClient.Builder().connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger{
//                    override fun log(message: String?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    }
//                }))
                .build()

        private var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()

        fun <T> getService(service: Class<T>): T{
            return retrofit.create(service)

        }

    }

}