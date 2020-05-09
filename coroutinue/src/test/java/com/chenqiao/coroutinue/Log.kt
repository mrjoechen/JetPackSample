package com.chenqiao.coroutinue

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

/**
 * Created by chenqiao on 2020/4/27.
 * e-mail : mrjctech@gmail.com
 */
fun log(msg: String) = println("${SimpleDateFormat("HH:mm:ss:SSS").format(Date(System.currentTimeMillis()))} [${Thread.currentThread()}] $msg")