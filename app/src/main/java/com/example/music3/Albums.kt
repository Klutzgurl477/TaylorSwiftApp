package com.example.music3
import android.os.Parcel
import android.os.Parcelable
data class Albums(
    val name: String,
    val artist: ArtistData,
    val url: String,
    val image: List<ImageData>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readParcelable(ArtistData::class.java.classLoader)!!,
        parcel.readString()!!,
        parcel.createTypedArrayList(ImageData.CREATOR)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(artist, flags)
        parcel.writeString(url)
        parcel.writeTypedList(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Albums> {
        override fun createFromParcel(parcel: Parcel): Albums {
            return Albums(parcel)
        }

        override fun newArray(size: Int): Array<Albums?> {
            return arrayOfNulls(size)
        }
    }
}