package fr.supinternet.androidtv.data.network.api.trakt.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RelatedMovieAPINetworkResponse(
    @SerializedName("ids")
    val ids: IdsAPINetworkResponse,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: Int
) : Parcelable