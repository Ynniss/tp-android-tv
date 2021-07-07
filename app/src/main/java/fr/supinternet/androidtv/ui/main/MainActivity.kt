package fr.supinternet.androidtv.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.ui.browse.BrowseFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, BrowseFragment())
            .commitAllowingStateLoss()
    }
}