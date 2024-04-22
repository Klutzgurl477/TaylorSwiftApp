package com.example.music3


data class Album(
    val name: String,
    val artist: ArtistData,
    val url: String,
    val image: List<ImageData>
)