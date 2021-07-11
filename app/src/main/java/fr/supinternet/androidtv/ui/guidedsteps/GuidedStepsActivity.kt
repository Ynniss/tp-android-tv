package fr.supinternet.androidtv.ui.guidedsteps

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.GuidedStepSupportFragment
import fr.supinternet.androidtv.ui.browse.BrowseFragment

class GuidedStepsActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GuidedStepSupportFragment.addAsRoot(this, GuidedStepsFragment(), android.R.id.content)
    }
}