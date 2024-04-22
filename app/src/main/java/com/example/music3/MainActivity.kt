package com.example.music3

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {

    private val apiKey = "fb3bfa345832967cd7762d99de6d095a"
    private val lastFmApiService = LastFmApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "oncreate()")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example usage to get Taylor Swift's top albums asynchronously
        GlobalScope.launch(Dispatchers.Main) {
            val artistName = "Taylor Swift"
            // Log before making the network request
            Log.d("MainActivity", "Before network request")
            // Log the API link
            Log.d("MainActivity", "API Link: ${lastFmApiService.getTopAlbumsUrl(artistName, apiKey)}")
            val topAlbums = getLastFmTopAlbums(artistName)
            Log.d("MainActivity", "after")
            // Log the parsed songs
            Log.d("MainActivity", "Parsed Songs: $topAlbums")
            displayTopAlbums(topAlbums)
        }
    }

    private suspend fun getLastFmTopAlbums(artistName: String): List<Album> {
        Log.d("MainActivity", "getLastFmTopAlbums() start")
        val result = withContext(Dispatchers.IO) {
            lastFmApiService.getTopAlbums(apiKey, artistName)
        }
        // Log after receiving the response
        Log.d("MainActivity", "After receiving response")
        // Log the response body
        Log.d("MainActivity", "Response body: $result")
        Log.d("MainActivity", "getLastFmTopAlbums() end")
        return result
    }

    private fun displayTopAlbums(topAlbums: List<Album>) {
        Log.d("MainActivity", "displayTopAlbums()")
        val topAlbumsTextView: TextView = findViewById(R.id.topAlbumsTextView)
        val sb = StringBuilder()
        for (album in topAlbums) {
            sb.append("${album.name} by ${album.artist.name}\n")
            // Log each album name
            Log.d("MainActivity", "Album: ${album.name}")
        }
        // Log before updating TextView
        Log.d("MainActivity", "Before updating TextView")
        Log.d("MainActivity", "Albums to display: $sb")
        topAlbumsTextView.text = sb.toString()
    }
}


data class Track(
    val name: String,
    val artist: String,
    val duration: Int,
    val url: String
)

class LastFmApiService {

    private val service: LastFmService

    init {
        // Initialize Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com/2.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(LastFmService::class.java)
    }

    suspend fun getTopAlbums(apiKey: String, artistName: String): List<Album> {
        val topAlbums = mutableListOf<Album>()

        val apiUrl = "https://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=$artistName&api_key=$apiKey&format=json&limit=10"
        Log.d("MainActivity", "API URL: $apiUrl")

        val response = service.getTopAlbums(artistName, apiKey)
        Log.d("MainActivity", "Response code: ${response.code()}")
        Log.d("MainActivity", "response")
        if (response.isSuccessful) {
            Log.d("MainActivity", "Response successful")
            val lastFmResponse = response.body()
            val albums = lastFmResponse?.topalbums?.album
            albums?.let {
                topAlbums.addAll(it)
                Log.d("MainActivity", "Top Albums: $it")
            }
        } else {
            Log.e("MainActivity", "Error: ${response.message()}")
        }

        return topAlbums
    }

    fun getTopAlbumsUrl(artistName: String, apiKey: String): String {
        Log.d("MainActivity", "getTopAlbumnsUrl()")
        return "https://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=$artistName&api_key=$apiKey&format=json&limit=10"
    }
}

interface LastFmService {
    @GET("?method=artist.gettopalbums&format=json&limit=10")
    suspend fun getTopAlbums(
        @Query("artist") artist: String,
        @Query("api_key") apiKey: String

    ): Response<LastFmResponse>
}

data class Album(
    val name: String,
    val artist: ArtistData,
    val url: String,
    val image: List<ImageData>
)

data class ArtistData(
    val name: String,
    val mbid: String,
    val url: String
)

data class ImageData(
    val text: String,
    val size: String
)

data class LastFmResponse(
    val topalbums: TopAlbumsData
)

data class TopAlbumsData(
    val album: List<Album>
)
