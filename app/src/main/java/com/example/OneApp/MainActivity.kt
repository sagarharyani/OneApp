package com.example.exam_q2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerColors: Spinner
    private lateinit var btnApplyColor: Button

    private val colors = arrayOf("Red", "Green", "Blue", "Yellow", "Cyan", "Magenta")
    private var selectedColor: String = "Red"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerColors = findViewById(R.id.spinnerColors)
        btnApplyColor = findViewById(R.id.btnApplyColor)

        // Set up the spinner with colors
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColors.adapter = adapter

        // Set up spinner item selected listener
        spinnerColors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedColor = colors[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

        // Set up button click listener
        btnApplyColor.setOnClickListener {
            changeBackgroundColor(selectedColor)
        }
    }

    private fun changeBackgroundColor(color: String) {
        val colorInt = when (color) {
            "Red" -> Color.RED
            "Green" -> Color.GREEN
            "Blue" -> Color.BLUE
            "Yellow" -> Color.YELLOW
            "Cyan" -> Color.CYAN
            "Magenta" -> Color.MAGENTA
            else -> Color.WHITE
        }
        findViewById<View>(android.R.id.content).setBackgroundColor(colorInt)
    }
}
