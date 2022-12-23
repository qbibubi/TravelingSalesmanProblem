package com.example.travelingsalesmanproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var outcomeTV: TextView
    private lateinit var startDestination: Spinner
    private lateinit var finishDestination: Spinner
    private lateinit var distanceInput: Number

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}