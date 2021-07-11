package fr.supinternet.androidtv.ui.preferences

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.supinternet.androidtv.R
import fr.supinternet.androidtv.ui.browse.BrowseFragment
import fr.supinternet.androidtv.ui.guidedsteps.GuidedStepsActivity

class PreferencesActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()
    }
}