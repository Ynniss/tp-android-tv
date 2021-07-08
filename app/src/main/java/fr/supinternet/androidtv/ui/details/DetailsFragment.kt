package fr.supinternet.androidtv.ui.details

import android.os.Bundle
import android.util.Log
import androidx.leanback.app.DetailsSupportFragment

class DetailsFragment : DetailsSupportFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val selectedMovieData = requireArguments().getString("movieData")

        selectedMovieData.let {
            Log.d("LE FILM SELECTIONNER", selectedMovieData.toString())
        }

    }
}