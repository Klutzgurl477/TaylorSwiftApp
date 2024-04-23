package com.example.music3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FactsActivity : AppCompatActivity() {

    // album order: 0: Lover, 1: Reputation, 2: FOLKLORE, 3: 1989, 4: Fearless, 5: Midnights
    // 6: 1989 (Deluxe), 7: Speak Now, 8: Red (Taylor's Version), 9: evermore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)

        // Get the album name from the intent extras
        val albumName = intent.getStringExtra("ALBUM_NAME")

        // Get the album index from the intent extras
        val albumIndex = intent.getIntExtra("ALBUM_INDEX", -1)

        // Log the album name to verify
        Log.d("FactsActivity", albumName ?: "Album name not found")
        Log.d("FactsActivity", (albumIndex ?: "Index name not found").toString())

        // Find the TextViewTitle by its ID
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)

        // Set the album name as the text for the TextViewTitle
        textViewTitle.text = albumName

        // album release year
        val release = arrayOf(2019, 2017, 2020, 2014, 2008, 2022, 2014, 2009, 2020)
        // Find the TextViewTitle by its ID
        val year = findViewById<TextView>(R.id.textViewReleaseYear)
        // Find the corresponding TextView and set the text
        when (albumIndex) {
            0 -> {
                Log.d("FactsActivity", "Lover")
                year.text = "2019"
            }
            1 -> {
                Log.d("FactsActivity", "Reputation")
                year.text = "2017"
            }
            2 -> {
                Log.d("FactsActivity", "FOLKLORE")
                year.text = "2020"
            }
            3 -> {
                Log.d("FactsActivity", "1989")
                year.text = "2014"
            }
            4 -> {
                Log.d("FactsActivity", "Fearless")
                year.text = "2008"
            }
            5 -> {
                Log.d("FactsActivity", "Midnights")
                year.text = "2022"
            }
            6 -> {
                Log.d("FactsActivity", "1989 (Deluxe)")
                year.text = "2014"
            }
            7 -> {
                Log.d("FactsActivity", "Speak Now")
                year.text = "2019"
            }
            8 -> {
                Log.d("FactsActivity", "Red (Taylor's Version)")
                year.text = "2009"
            }
            9 -> {
                Log.d("FactsActivity", "evermore")
                year.text = "2020"
            }
        }

        // Find the back button by its ID
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        // Set click listener for the back button
        buttonBack.setOnClickListener {
            // Create an intent to navigate back to MainActivity
            val intent = Intent(this@FactsActivity, MainActivity::class.java)
            startActivity(intent)
            // Finish the current activity
            finish()
        }

        // Find the TextViews by their IDs
        val textViewFact1 = findViewById<TextView>(R.id.textViewFact1)
        val textViewFact2 = findViewById<TextView>(R.id.textViewFact2)
        val textViewFact3 = findViewById<TextView>(R.id.textViewFact3)
        val textViewFact4 = findViewById<TextView>(R.id.textViewFact4)
        val textViewFact5 = findViewById<TextView>(R.id.textViewFact5)
        val textViewFact6 = findViewById<TextView>(R.id.textViewFact6)
        val textViewFact7 = findViewById<TextView>(R.id.textViewFact7)
        val textViewFact8 = findViewById<TextView>(R.id.textViewFact8)
        val textViewFact9 = findViewById<TextView>(R.id.textViewFact9)
        val textViewFact10 = findViewById<TextView>(R.id.textViewFact10)

        // Set text for each TextView (replace with your facts)
        textViewFact1.text = "Fact 1: This is a sample fact."
        textViewFact2.text = "Fact 2: This is another sample fact."
        textViewFact3.text = "Fact 3: This is yet another sample fact."
        textViewFact4.text = "Fact 4: Here's a fascinating fact."
        textViewFact5.text = "Fact 5: Did you know...?"
        textViewFact6.text = "Fact 6: Another interesting fact."
        textViewFact7.text = "Fact 7: This fact will blow your mind!"
        textViewFact8.text = "Fact 8: A surprising fact awaits."
        textViewFact9.text = "Fact 9: Yet another incredible fact!"
        textViewFact10.text = "Fact 10: Last but not least, an amazing fact."
    }
}
