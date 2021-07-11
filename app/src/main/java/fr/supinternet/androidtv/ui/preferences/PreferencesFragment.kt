package fr.supinternet.androidtv.ui.preferences

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.preference.LeanbackPreferenceFragmentCompat
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import fr.supinternet.androidtv.R
import fr.supinternet.androidtv.data.network.NetworkManager
import fr.supinternet.androidtv.data.network.model.Movie
import fr.supinternet.androidtv.ui.main.DetailsActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.Serializable


class PreferencesFragment : LeanbackPreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

}
