package com.example.music3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class FactsActivity : AppCompatActivity() {

    // album order: 0: Lover, 1: Reputation, 2: FOLKLORE, 3: 1989, 4: Fearless, 5: Midnights
    // 6: 1989 (Deluxe), 7: Speak Now, 8: Red (Taylor's Version), 9: evermore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_info)

        // Album name that was clicked
        val albumName = intent.getStringExtra("ALBUM_NAME")
        // Get the album index that was clicked
        val albumIndex = intent.getIntExtra("ALBUM_INDEX", -1)
        // Find the Album Name by its ID
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        // Find the release year by its ID
        val year = findViewById<TextView>(R.id.textViewReleaseYear)
        // Find the back button by its ID
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        // Find the album cover image view by ID
        val viewAlbumImageCover = findViewById<ImageView>(R.id.album_img_cover)
        // Find the top songs text view by ID
        val viewTop = findViewById<TextView>(R.id.textViewTopSongs)

        // Set the album name as the text for the TextViewTitle
        textViewTitle.text = albumName

        // change the information depending on the album
        when (albumIndex) {
            0 -> {
                // Lover
                year.text = "2019"
                viewAlbumImageCover.setImageResource(R.drawable.lover)
                viewTop.text = "1. Cruel Summer\n2. Lover\n3. The Man"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.lover))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.lover)
            }
            1 -> {
                // Reputation
                year.text = "2017"
                viewAlbumImageCover.setImageResource(R.drawable.reputation)
                viewTop.text = "1. Delicate\n2. Don't Blame Me\n3. Getaway Car"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.reputation))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.reputation)
            }
            2 -> {
                // folklore
                textViewTitle.text = "folklore"
                year.text = "2020"
                viewAlbumImageCover.setImageResource(R.drawable.foklore)
                viewTop.text = "1. the 1\n2. august\n3. illicit affairs"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.folklore))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.folklore)
            }
            3 -> {
                // 1989
                year.text = "2014"
                viewAlbumImageCover.setImageResource(R.drawable._989)
                viewTop.text = "1. Blank Space\n2. Style\n3. Shake It Off"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.c1989))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.c1989)
            }
            4 -> {
                // Fearless
                year.text = "2008"
                viewAlbumImageCover.setImageResource(R.drawable.fearless)
                viewTop.text = "1. Love Story\n2. You Belong With Me\n3. The Way I Loved You"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.fearless))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.fearless)

            }
            5 -> {
                // Midnights
                year.text = "2022"
                viewAlbumImageCover.setImageResource(R.drawable.midnights)
                viewTop.text = "1. Anti-Hero\n2. Lavender Haze\n3. Bejeweled"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.midnights))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.midnights)
            }
            6 -> {
                // 1989 (Deluxe)
                year.text = "2014"
                viewAlbumImageCover.setImageResource(R.drawable._989_deluxe)
                viewTop.text = "1. Wonderland\n2. You Are In Love\n3. New Romantics"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.d1989))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.d1989)
            }
            7 -> {
                // Speak Now
                year.text = "2019"
                viewAlbumImageCover.setImageResource(R.drawable.speak_now)
                viewTop.text = "1. Back To December\n2. Mean\n3. Enchanted"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.speaknow))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.speaknow)
            }
            8 -> {
                // Red (Taylor's Version)
                year.text = "2009"
                viewAlbumImageCover.setImageResource(R.drawable.red)
                viewTop.text = "1. All Too Well (10 Minute Version) (Taylor's Version)\n2. 22\n3. Red"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.red))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.red)
            }
            9 -> {
                // evermore
                year.text = "2020"
                viewAlbumImageCover.setImageResource(R.drawable.evermore)
                viewTop.text = "1. willow\n2. champagne problems\n3. 'tis the damn season'"
                textViewTitle.setTextColor(ContextCompat.getColor(this, R.color.evermore))
                buttonBack.backgroundTintList = ContextCompat.getColorStateList(this, R.color.evermore)
            }
        }

        buttonBack.setOnClickListener {
            // Create an intent to navigate back to MainActivity
            val intent = Intent(this@FactsActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
