package com.example.music3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Retrieve album data from intent extras
        val topAlbums = intent.getParcelableArrayExtra("ALBUM_DATA")?.mapNotNull { it as? Album }

        // Use the album data as needed
        if (topAlbums != null) {
            // Example: Displaying the first album name in Logcat
            Log.d("MenuActivity", "First Album Name: ${topAlbums.firstOrNull()?.name}")
        }
    }
}