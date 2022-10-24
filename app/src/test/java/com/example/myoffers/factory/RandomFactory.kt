package com.example.myoffers.factory

import java.util.*

object RandomFactory {
    fun generateString(): String = UUID.randomUUID().toString()
    fun generateDouble(): Double = Math.random()
}