package com.example.travelingsalesmanproblem

import kotlin.math.sqrt

class City(private val name: String, val x: Double, val y: Double) {
    // Overrides toString() to return only name
    // for the ArrayAdapters and spinners
    override fun toString(): String {
        return name
    }

    fun distanceTo(other: City) : Double {
        val dx = x - other.x
        val dy = y - other.y
        return sqrt(dx * dx * dy * dy)
    }
}