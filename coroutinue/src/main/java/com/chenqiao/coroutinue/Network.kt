package com.chenqiao.coroutinue

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

/**
 * Created by chenqiao on 2020/4/21.
 * e-mail : mrjctech@gmail.com
 */
private val service by lazy {

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5000L, TimeUnit.MILLISECONDS)
            .addInterceptor(interceptor)
            .build()

    val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    retrofit.create(GithubInterface::class.java)

}

fun getNetworkService() = service


interface GithubInterface{

    @GET("/article/list/{page}/json")
    suspend fun repos(@Path("page")page: String): ResponseBody

}

//object Network {
//    //retorfit实例，在这里做一些统一网络配置，如添加转换器、设置超时时间等
//    private val retrofit = Retrofit.Builder()
//            .client(OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS).build())
//            .baseUrl("https://www.wanandroid.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//
//    //网络层访问服务
//    val apiService = retrofit.create<GithubInterface>(GithubInterface::class.java)
//
//}