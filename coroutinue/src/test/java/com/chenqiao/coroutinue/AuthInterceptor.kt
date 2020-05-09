package com.chenqiao.coroutinue

import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by chenqiao on 2020-01-26.
 * e-mail : mrjctech@gmail.com
 */

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        return chain.proceed(originalRequest.newBuilder()
            .apply {
                if (originalRequest.method().equals("POST")){
                    val body = originalRequest.body()
                    if(body is FormBody){
                        val builder = FormBody.Builder()
                        for (i in 0 until body.size()) {
                            builder.add(body.encodedName(i), body.encodedValue(i))
                        }

                        val l = System.currentTimeMillis() / 1000
                        val auth_key = MD5.MD5("chenqiao${l}")
                        post(builder.add("auth_key", auth_key).add("timestamp", ""+l).build())
                    }
                }

            }
            .build()
        )
    }

}