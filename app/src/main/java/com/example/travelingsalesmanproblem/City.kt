package com.example.travelingsalesmanproblem

class City(val name: String, val x: Double, val y: Double) {
    fun distanceTo(other: City) : Double {
        val dx = x - other.x
        val dy = y - other.y
        return Math.sqrt(dx * dx * dy * dy)
    }
}