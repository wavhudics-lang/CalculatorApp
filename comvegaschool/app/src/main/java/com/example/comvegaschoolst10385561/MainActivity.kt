package com.example.comvegaschoolst10385561

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal.ZERO
import java.math.RoundingMode
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    private var value1: TextView? = null
    private var value2: TextView? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value1 = findViewById(R.id.enter1)
        value2 = findViewById(R.id.enter2)
        answer = findViewById(R.id.tvAnswer)

        val selectAdd = findViewById<Button>(R.id.selectAdd)
        val selectSubtract = findViewById<Button>(R.id.selectSubtract)
        val selectMultiply = findViewById<Button>(R.id.selectMultiply)
        val selectDivide = findViewById<Button>(R.id.selectDivide)
        val selectSquare = findViewById<Button>(R.id.selectSquare)
        val selectPower = findViewById<Button>(R.id.selectPower)
        val selectStatistics = findViewById<Button>(R.id.selectStatistics)

        selectAdd.setOnClickListener {
            add()
        }

        selectSubtract.setOnClickListener {
            subtract()
        }

        selectMultiply.setOnClickListener {
            multiple()
        }

        selectDivide.setOnClickListener {
            divide()
        }

        selectSquare.setOnClickListener {
            squareRoot()
        }

        selectPower.setOnClickListener {
            power()
        }

        selectStatistics.setOnClickListener{
            statistics()
            val intent = Intent(this,Stats::class.java)
            startActivity(intent)
        }
    }

    private fun add() {

        if (inputIsNotEmpty()) {

            val user1 = value1?.text.toString().trim().toBigDecimal()
            val user2 = value2?.text.toString().trim().toBigDecimal()
            answer?.text = "${value1?.text.toString().trim().toBigDecimal()} + ${value2?.text.toString().trim().toBigDecimal()} = ${user1.add(user2)}"
        }
    }

    private fun inputIsNotEmpty(): Boolean {

        var a = true
        if (value1?.text.toString().trim().isEmpty()) {
            value1?.error = "Required"
            a = false
        }
        if (value2?.text.toString().trim().isEmpty()) {
            value2?.error = "Required"
            a = false
        }
        return a

    }

    private fun subtract() {

        if (inputIsNotEmpty()) {

            val user1 = value1?.text.toString().trim().toBigDecimal()
            val user2 = value2?.text.toString().trim().toBigDecimal()
            answer?.text = "${value1?.text.toString().trim().toBigDecimal()} - ${value2?.text.toString().trim().toBigDecimal()} = ${user1.subtract(user2)}"
        }
    }

    private fun multiple() {

        if (inputIsNotEmpty()) {

            val user1 = value1?.text.toString().trim().toBigDecimal()
            val user2 = value2?.text.toString().trim().toBigDecimal()
            answer?.text = "${value1?.text.toString().trim().toBigDecimal()} * ${value2?.text.toString().trim().toBigDecimal()} = ${user1.multiply(user2)}"
        }
    }

    private fun isNotZero(): Boolean {
        var b = true
        if (value2?.text.toString().trim().toBigDecimal() == ZERO) {
            value2?.error = "Cannot Divide by Zero"
            b = false
        }
        return b
    }

    private fun divide() {

        if (inputIsNotEmpty()) {
            val user1 = value1?.text.toString().trim().toBigDecimal()
            val user2 = value2?.text.toString().trim().toBigDecimal()


            if (isNotZero()) {
                answer?.text = "${value1?.text.toString().trim().toBigDecimal()} / ${value2?.text.toString().trim().toBigDecimal()} = ${user1.divide(user2, 2, RoundingMode.HALF_UP)}"
            }
        }
    }


    private fun squareRoot() {
        if (inputIsNotEmpty()) {

            val user1 = value1?.text.toString().trim().toBigDecimal()
            val user2 = value2?.text.toString().trim().toBigDecimal()
            answer?.text = "Sqr(${value1?.text.toString().trim().toBigDecimal()}) = ${sqrt(user1.toDouble())} and\n Sqr(${value2?.text.toString().toBigDecimal()} = ${sqrt(user2.toDouble())}"

            if (user1 < ZERO) {
                val value1 = -user1
                answer?.text = "Spr(${-value1}) = ${sqrt(value1.toDouble())}i"
            }
        }
    }

    private fun power() {
        if (inputIsNotEmpty()) {
            val user1 = value1?.text.toString().trim().toBigDecimal().toDouble()
            val user2 = value2?.text.toString().trim().toBigDecimal().toInt()

            var result = 1.0
            for (i in 1..user2) {
                result *= user1
            }
            answer?.text = "$user1 ^ $user2 = $result"
        }
    }

    private fun statistics() {

    }
}
