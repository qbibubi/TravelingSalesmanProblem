package com.example.travelingsalesmanproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var outcomeTV: TextView
    private lateinit var startDestination: Spinner
    private lateinit var finishDestination: Spinner
    private lateinit var applyButton: Button
    private lateinit var distanceButton: Button
    private lateinit var distanceInput: EditText
    private lateinit var cities: List<City>
    private var startSelected: Int = 0
    private var finishSelected: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cities = listOf(
            City("Gdynia", 2340.0, -5238.0),
            City("Gdańsk", 1880.0, -4865.0),
            City("Kraków", 15123.0, -812351.0),
            City("Katowice", 3241.0, 1524352.0),
            City("Elbląg", 55512.0, 11234.0),
            City("Warszawa", 209817.0, -23491.0),
            City("Białystok", 35891.0, -10034.0),
            City("Łódź", 323.0, 19857.0)
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        startDestination = findViewById(R.id.firstCitySpinner)
        startDestination.adapter = adapter
        startDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //val city = parent?.getItemAtPosition(position) as City
                startSelected = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        finishDestination = findViewById(R.id.lastCitySpinner)
        finishDestination.adapter = adapter
        finishDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //val city = parent?.getItemAtPosition(position) as City
                finishSelected = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        outcomeTV = findViewById(R.id.outcomeTV)
        applyButton = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            var path = solveTSP(cities)
            outcomeTV.text = path.toString()

            val distance = cities[startSelected].distanceTo(cities[finishSelected])
            Log.wtf("Distance", distance.toString())
        }

        distanceInput = findViewById(R.id.distanceNumber)
        distanceButton = findViewById(R.id.setDistanceButton)
        distanceButton.setOnClickListener {
            // Base case: if both cities are the same return
            if (cities[startSelected] == cities[finishSelected]) {
                // TODO("Toast notification both cities are equal")
                return@setOnClickListener
            }

            // Base case: if distanceInput is empty return
            // and output toast notification
            if (distanceInput.text.isEmpty()) {
                // TODO("Add toast notification that text cannot be empty")
                // "Distance cannot be empty. Nothing has changed."
                return@setOnClickListener
            }
        }

    }
}