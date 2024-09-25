package com.example.certificatemaker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var UserInputEmail=findViewById<EditText>(R.id.textArea_information)
        var UserInputPassword=findViewById<EditText>(R.id.textArea_information2)
        var submitButton=findViewById<Button>(R.id.button)
//        var finalInput=

        submitButton.setOnClickListener{
            var finalInputEmail=findViewById<EditText>(R.id.textArea_information);
            var fIfinal=finalInputEmail.text.toString()
            var tvresult=findViewById<TextView>(R.id.textView21)
            tvresult.text=fIfinal;

        }



    }

}