package com.chenqiao.sample.net.retrofit

import com.chenqiao.sample.data.model.Follow
import com.chenqiao.sample.data.model.Repos
import com.chenqiao.sample.data.model.User
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by chenqiao on 2019-12-26.
 * e-mail : mrjctech@gmail.com
 */


interface GithubServices {

    @GET("/users/{username}")
    fun userinfo(@Path("username") userName: String): Call<User>


    @GET("/users/{username}/repos")
    fun repos(@Path("username") userName: String): Call<Repos>

    @GET("/users/{username}/following")
    fun following(@Path("username") userName: String): Call<Follow>


    @GET("/users/{username}/stared")
    fun stared(@Path("username") userName: String): Call<Repos>


    @GET("/users/{username}/followers")
    fun followers(@Path("username") userName: String): Call<Follow>

}