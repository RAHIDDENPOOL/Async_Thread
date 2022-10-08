package com.example.asyncthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

fun main() {
    LoadHelper.load()
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