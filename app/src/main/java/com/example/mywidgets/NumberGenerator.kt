package com.example.mywidgets

import java.util.Random

internal object NumberGenerator {
    fun generator(max: Int): Int {
        val random = Random()
        return random.nextInt(max)
    }
}