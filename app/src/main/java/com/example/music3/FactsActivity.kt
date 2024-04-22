package com.example.music3

import android.os.Bundle
import android.widget.TextView // Import TextView
import androidx.appcompat.app.AppCompatActivity

class FactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)

        // Find the TextViews by their IDs
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
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
        textViewTitle.text = "Interesting Facts"
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