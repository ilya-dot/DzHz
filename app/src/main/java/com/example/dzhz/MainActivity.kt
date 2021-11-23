package com.example.dzhz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var buttonLoadHz: Button
    private lateinit var textViewJson: TextView
    private lateinit var apiWorker: ApiWorker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url = "http://localhost:8080/user/getAllUsers"


        apiWorker = ApiWorker(applicationContext)

        textViewJson = findViewById(R.id.textViewJson)

        buttonLoadHz = findViewById(R.id.buttonLoadHz)
        buttonLoadHz.setOnClickListener {
            apiWorker.makeGetRequest(url,::updateTextViewJson)
        }
    }

    fun updateTextViewJson(data: String){
        textViewJson.text = data
    }
}