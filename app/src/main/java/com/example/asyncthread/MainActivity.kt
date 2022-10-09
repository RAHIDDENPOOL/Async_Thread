package com.example.asyncthread

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(): Unit = runBlocking {

    launch {
        delay(3000L)
        println("world")
    }
    println("Hello")
    }

/*object LoadHelper {
    private var progress: Int = 0
    private fun startLoading() {
        thread {
            while (progress < 100) {
                progress++
                Thread.sleep(500)
            }
        }
    }

    private fun updateProgressBar() {
        thread {
            while (progress < 100) {
                println(getProgressString())
                Thread.sleep(500)
            }
        }
    }

    private fun getProgressString(): String {
        val str = StringBuilder()
        for (i in 0..100) {
            if (i < progress)
                str.append('#')
            else str.append('.')
        }
        str.append("$progress %")
        return str.toString()
    }

    fun load() {
        startLoading()
        updateProgressBar()
    }
}*/