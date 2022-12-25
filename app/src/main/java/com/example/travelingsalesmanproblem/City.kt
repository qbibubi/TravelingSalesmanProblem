package com.example.travelingsalesmanproblem

import kotlin.math.sqrt

class City(val name: String, val x: Double, val y: Double) {
    override fun toString(): String {
        return name
    }

    fun distanceTo(other: City) : Double {
        val dx = x - other.x
        val dy = y - other.y
        return sqrt(dx * dx * dy * dy)
    }
}