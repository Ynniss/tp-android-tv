package fr.supinternet.androidtv.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.ui.browse.BrowseFragment
import fr.supinternet.androidtv.ui.details.DetailsFragment

class DetailsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, DetailsFragment())
            .commitAllowingStateLoss()
    }
}