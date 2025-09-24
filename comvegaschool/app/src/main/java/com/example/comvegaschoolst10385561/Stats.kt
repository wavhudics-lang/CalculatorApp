package com.example.comvegaschoolst10385561

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Stats : AppCompatActivity() {

    private lateinit var statNumber1: EditText
    private lateinit var addBtn: Button
    private lateinit var monNumbers: TextView
    private lateinit var answer: TextView
    private lateinit var btnClr: Button
    private lateinit var btnAvg: Button
    private lateinit var btnMinMax: Button

    private val maxNumbers = 10
    private val numberArray = IntArray(maxNumbers)
    private var numberCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        statNumber1 = findViewById(R.id.statNumber1)
        addBtn = findViewById(R.id.addBtn)
        monNumbers = findViewById(R.id.monNumbers)
        answer = findViewById(R.id.tvAnswer)
        btnClr = findViewById(R.id.btnClr)
        btnAvg = findViewById(R.id.btnAvg)
        btnMinMax = findViewById(R.id.btnMinMax)



        addBtn.setOnClickListener{
            val enteredNumber = statNumber1.text.toString()
            if (numberCount < maxNumbers) {
                if (enteredNumber.isNotEmpty()) {
                    val number = enteredNumber.toInt()
                    numberArray[numberCount] = number
                    numberCount++
                    updateNumbersTextView()
                    statNumber1.text.clear()
                }
            }
        }

        btnClr.setOnClickListener{
            numberArray.fill(0)
            numberCount = 0
            updateNumbersTextView()
            answer.text = ""
            statNumber1.text.clear()
        }

        btnAvg.setOnClickListener {
            if (numberCount > 0) {
                val average = numberArray.take(numberCount).average()
                answer.text = "Average:$average"
            } else {
                monNumbers.text = "No numbers entered"
            }
        }

        btnMinMax.setOnClickListener {
            if (numberCount > 0) {
                var min = numberArray[0]
                var max = numberArray[0]

                for (i in 1 until numberCount) {
                    if (numberArray[i] < min) {
                        min = numberArray[i]
                    }
                    if (numberArray[i] > max) {
                        max = numberArray[i]
                    }
                }
                answer.text = "Min: $min, Max: $max"
            } else {
                monNumbers.text = "No numbers to find Min/Max"
            }
        }
    }
    private fun updateNumbersTextView() {
        val enteredNumbers = numberArray.take(numberCount).joinToString(",")
        monNumbers.text = "$enteredNumbers"
    }
}