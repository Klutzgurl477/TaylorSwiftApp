package com.example.music3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TaylorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.taylor)

        // Find the back button by its ID
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        // Set click listener for the back button
        buttonBack.setOnClickListener {
            // Create an intent to navigate back to MainActivity
            val intent = Intent(this@TaylorActivity, MainActivity::class.java)
            startActivity(intent)
            // Finish the current activity
            finish()
        }
    }
}
