package com.example.travelingsalesmanproblem

fun solveTSP(cities: List<City>): List<City> {
    // Base case: if there are no cities, return an empty list
    if (cities.isEmpty()) return emptyList()

    // Base case: if there is only one city, return a list with that city
    if (cities.size == 1) return cities

    // Initialize the minimum distance to a very large value
    var minDistance = Double.MAX_VALUE
    var minPath: List<City> = emptyList()

    // Iterate over all possible starting cities
    for (i in cities.indices) {
        // Compute the sub-problem with the remaining cities
        val remainingCities = cities.toMutableList()
        remainingCities.removeAt(i)
        val subproblemPath = solveTSP(remainingCities)

        // Compute the total distance of the current permutation
        val distance = cities[i].distanceTo(subproblemPath.first()) + subproblemPath.last().distanceTo(cities[i]) + subproblemPath.zipWithNext()
            .sumOf { (a, b) -> a.distanceTo(b) }

        // if the current permutation has a shorter distance, update the minimum distance and path
        if (distance < minDistance) {
            minDistance = distance
            minPath = listOf(cities[i]) + subproblemPath + cities[i]
        }
    }

    return minPath
}