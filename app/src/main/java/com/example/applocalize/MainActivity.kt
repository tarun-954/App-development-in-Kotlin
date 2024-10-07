package com.example.applocalize

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioGroup
import java.util.*  // Required for Locale class
import android.content.res.Configuration  // Required for updating configuration
import android.content.res.Resources  // Required to access resources
import android.os.Build
import android.util.log



import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge layout
        setContentView(R.layout.activity_main)

        // Adjusts padding for system bars dynamically (like status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Reference to the TextView where we will display the message
        val msg: TextView = findViewById(R.id.textView)

        // Sets up the radio group for language selection
        val rg: RadioGroup = findViewById(R.id.radiogroup)

        // Listener for when the user selects a language option
        rg.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton -> {
                    setLocale("hi")  // Set English locale

                    log.e(tag: "MainActivity_btnClick_hindi" );

                    msg.text = "Hello"
                }
                R.id.radioButton2 -> {
                    setLocale("gu")  // Set French locale
                    msg.text = "Bonjour"
                }
            }
        }
    }

    // Function to change the app's locale
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = resources.configuration

        // Update the app configuration with the selected locale
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Refresh the activity to apply the new locale
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            recreate()
        }
    }
}
