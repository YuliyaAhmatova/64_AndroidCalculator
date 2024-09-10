package com.example.a64_androidcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var firstValueOneOperandET: EditText
    private lateinit var secondValueOneOperandET: EditText
    private lateinit var thirdValueOneOperandET: EditText
    private lateinit var firstValueTwoOperandET: EditText
    private lateinit var secondValueTwoOperandET: EditText
    private lateinit var thirdValueTwoOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    private lateinit var firstValueResultTV: TextView
    private lateinit var secondValueResultTV: TextView
    private lateinit var thirdValueResultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firstValueOneOperandET = findViewById(R.id.firstValueOneOperandET)
        secondValueOneOperandET = findViewById(R.id.secondValueOneOperandET)
        thirdValueOneOperandET = findViewById(R.id.thirdValueOneOperandET)
        firstValueTwoOperandET = findViewById(R.id.firstValueTwoOperandET)
        secondValueTwoOperandET = findViewById(R.id.secondValueTwoOperandET)
        thirdValueTwoOperandET = findViewById(R.id.thirdValueTwoOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)

        firstValueResultTV = findViewById(R.id.firstValueResultTV)
        secondValueResultTV = findViewById(R.id.secondValueResultTV)
        thirdValueResultTV = findViewById(R.id.thirdValueResultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (firstValueOneOperandET.text.isEmpty() ||
            secondValueOneOperandET.text.isEmpty() ||
            thirdValueOneOperandET.text.isEmpty() ||
            firstValueTwoOperandET.text.isEmpty() ||
            secondValueTwoOperandET.text.isEmpty() ||
            thirdValueTwoOperandET.text.isEmpty()
        ) {
            return
        }
        val firstValueOneOperand = firstValueOneOperandET.text.toString().toInt()
        val secondValueOneOperand = secondValueOneOperandET.text.toString().toInt()
        val thirdValueOneOperand = thirdValueOneOperandET.text.toString().toInt()
        val firstValueTwoOperand = firstValueTwoOperandET.text.toString().toInt()
        val secondValueTwoOperand = secondValueTwoOperandET.text.toString().toInt()
        val thirdValueTwoOperand = thirdValueTwoOperandET.text.toString().toInt()
        val result = when (v.id) {
            R.id.buttonSumBTN -> (firstValueOneOperand*3600)+(secondValueOneOperand*60)+thirdValueOneOperand+
                    (firstValueTwoOperand*3600)+(secondValueTwoOperand*60)+thirdValueTwoOperand

            R.id.buttonDifBTN -> ((firstValueOneOperand*3600)+(secondValueOneOperand*60)+thirdValueOneOperand)-
                    ((firstValueTwoOperand*3600)+(secondValueTwoOperand*60)+thirdValueTwoOperand)

            else -> 0
        }
        firstValueResultTV.text = (result/3600).toString()
        secondValueResultTV.text = ((result%3600)/60).toString()
        thirdValueResultTV.text = ((result%3600)%60).toString()
    }
}

