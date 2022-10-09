package com.example.asyncthread

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            delay(3000L)
            Log.d(TAG, "Coroutine works ${Thread.currentThread().name}")
        }
        Log.d(TAG, "Hello From Main Thread ${Thread.currentThread().name}")
    }
}

object LoadHelper {
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
}