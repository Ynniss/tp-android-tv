package fr.supinternet.androidtv.ui.main

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.ui.browse.BrowseFragment
import fr.supinternet.androidtv.ui.guidedsteps.GuidedStepsActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, BrowseFragment())
            .commitAllowingStateLoss()

        val intent = Intent(this, GuidedStepsActivity::class.java)
        startActivity(intent)
    }
}