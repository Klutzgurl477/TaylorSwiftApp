package com.example.music3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
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

        // Find the TextViewTitle by its ID
        val year = findViewById<TextView>(R.id.textViewReleaseYear)

        //get the album image cover
        val viewAlbumImageCover = findViewById<ImageView>(R.id.album_img_cover)
        val viewTop = findViewById<TextView>(R.id.textViewTopSongs)

        // change the information depending on the album
        when (albumIndex) {
            0 -> {
                Log.d("FactsActivity", "Lover")
                year.text = "2019"
                // change image here
                viewAlbumImageCover.setImageResource(R.drawable.lover)
                viewTop.text = "1. Cruel Summer\n2. Lover\n3. The Man"
            }
            1 -> {
                Log.d("FactsActivity", "Reputation")
                year.text = "2017"
                viewAlbumImageCover.setImageResource(R.drawable.reputation)
                viewTop.text = "1. Delicate\n2. Don't Blame Me\n3. Getaway Car"
            }
            2 -> {
                Log.d("FactsActivity", "FOLKLORE")
                textViewTitle.text = "folklore"
                year.text = "2020"
                viewAlbumImageCover.setImageResource(R.drawable.foklore)
                viewTop.text = "1. the 1\n2. august\n3. illicit affairs"
            }
            3 -> {
                Log.d("FactsActivity", "1989")
                year.text = "2014"
                viewAlbumImageCover.setImageResource(R.drawable._989)
                viewTop.text = "1. Blank Space\n2. Style\n3. Shake It Off"
            }
            4 -> {
                Log.d("FactsActivity", "Fearless")
                year.text = "2008"
                viewAlbumImageCover.setImageResource(R.drawable.fearless)
                viewTop.text = "1. Love Story\n2. You Belong With Me\n3. The Way I Loved You"

            }
            5 -> {
                Log.d("FactsActivity", "Midnights")
                year.text = "2022"
                viewAlbumImageCover.setImageResource(R.drawable.midnights)
                viewTop.text = "1. Anti-Hero\n2. Lavender Haze\n3. Bejeweled"
            }
            6 -> {
                Log.d("FactsActivity", "1989 (Deluxe)")
                year.text = "2014"
                viewAlbumImageCover.setImageResource(R.drawable._989_deluxe)
                viewTop.text = "1. Wonderland\n2. You Are In Love\n3. New Romantics"
            }
            7 -> {
                Log.d("FactsActivity", "Speak Now")
                year.text = "2019"
                viewAlbumImageCover.setImageResource(R.drawable.speak_now)
                viewTop.text = "1. Back To December\n2. Mean\n3. Enchanted"
            }
            8 -> {
                Log.d("FactsActivity", "Red (Taylor's Version)")
                year.text = "2009"
                viewAlbumImageCover.setImageResource(R.drawable.red)
                viewTop.text = "1. All Too Well (10 Minute Version) (Taylor's Version)\n2. 22\n3. Red"
            }
            9 -> {
                Log.d("FactsActivity", "evermore")
                year.text = "2020"
                viewAlbumImageCover.setImageResource(R.drawable.evermore)
                viewTop.text = "1. willow\n2. champagne problems\n3. 'tis the damn season'"
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

    }
}
