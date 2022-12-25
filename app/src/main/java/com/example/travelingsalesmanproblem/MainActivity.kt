package com.example.travelingsalesmanproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var outcomeTV: TextView
    private lateinit var startDestination: Spinner
    private lateinit var finishDestination: Spinner
    private lateinit var distanceInput: Number
    private lateinit var applyButton: Button
    private lateinit var distanceButton: Button
    private lateinit var cities: List<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        startDestination = findViewById(R.id.firstCitySpinner)
        startDestination.adapter = adapter
        startDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val city = parent?.getItemAtPosition(position) as City
                Log.d("City1", city.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        finishDestination = findViewById(R.id.lastCitySpinner)
        finishDestination.adapter = adapter
        finishDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val city = parent?.getItemAtPosition(position) as City
                Log.d("City2", city.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        outcomeTV = findViewById(R.id.outcomeTV)
        applyButton = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            var path = solveTSP(cities)
            outcomeTV.text = path.toString()
        }
    }
}