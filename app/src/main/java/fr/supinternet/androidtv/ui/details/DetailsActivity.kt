package fr.supinternet.androidtv.ui.main

import android.R
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import fr.supinternet.androidtv.ui.details.DetailsFragment


class DetailsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val detailsFragment = DetailsFragment()
        val intent = intent
        val movieData = intent.getStringExtra("movieData")

        val bundle = Bundle()
        bundle.putString("movieData", movieData)
        detailsFragment.setArguments(bundle)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, detailsFragment)
        transaction.commit()
    }
}