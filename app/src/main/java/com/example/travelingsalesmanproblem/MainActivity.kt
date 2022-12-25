package com.example.travelingsalesmanproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var outcomeTV: TextView
    private lateinit var startDestination: Spinner
    private lateinit var finishDestination: Spinner
    private lateinit var distanceInput: Number
    private lateinit var cities: List<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize a list of eight cities
        cities = listOf(
            City("Gdynia", 0.0, 0.0),
            City("Gdańsk", 1.0, 0.0),
            City("Kraków", 0.0, 1.0),
            City("Katowice", 1.0, 1.0),
            City("Elbląg", 2.0, 0.0),
            City("Warszawa", 2.0, 1.0),
            City("Białystok", 3.0, 0.0),
            City("Łódź", 3.0, 1.0)
        )



    }
}