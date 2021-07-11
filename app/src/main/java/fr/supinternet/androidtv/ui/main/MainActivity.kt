package fr.supinternet.androidtv.ui.main

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.ui.browse.BrowseFragment
import fr.supinternet.androidtv.ui.guidedsteps.GuidedStepsActivity
import fr.supinternet.androidtv.ui.preferences.PreferencesActivity
import fr.supinternet.androidtv.ui.preferences.SettingsFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, BrowseFragment())
            .commitAllowingStateLoss()

        // ETAPE 10
        //val intent = Intent(this, PreferencesActivity::class.java)

        // ETAPE 9
        // val intent = Intent(this, GuidedStepsActivity::class.java)

        startActivity(intent)
    }
}