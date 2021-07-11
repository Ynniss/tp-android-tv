package fr.supinternet.androidtv.data.network.api.trakt.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IdsAPINetworkResponse(
    @SerializedName("imdb")
    val imdb: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("tmdb")
    val tmdb: Int,
    @SerializedName("trakt")
    val trakt: Int
) : Parcelable