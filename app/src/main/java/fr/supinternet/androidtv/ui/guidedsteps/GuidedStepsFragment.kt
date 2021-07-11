package fr.supinternet.androidtv.ui.guidedsteps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import fr.supinternet.androidtv.data.network.NetworkManager
import fr.supinternet.androidtv.data.network.model.Movie
import fr.supinternet.androidtv.ui.main.DetailsActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.Serializable


class GuidedStepsFragment : GuidedStepSupportFragment() {
    override fun onCreateGuidance(savedInstanceState: Bundle?): GuidanceStylist.Guidance {
        return GuidanceStylist.Guidance(
            "Android, c'est la vie ?",
            "Des détails...",
            "Question 1",
            null
        )
    }

    override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {

        // C'est à vous !


        val actionYes = GuidedAction.Builder(requireContext()).id(0).title("Oui").build()
        val actionNo = GuidedAction.Builder(requireContext()).id(1).title("Non").build()

        val actionMaybe = GuidedAction.Builder(requireContext()).id(3).title("Peut-être").build()
        val actionCertainly =
            GuidedAction.Builder(requireContext()).id(4).title("Certainement").build()

        val subActionsList = mutableListOf<GuidedAction>(actionMaybe, actionCertainly)

        val actionDoubt = GuidedAction.Builder(requireContext()).id(2).title("J'hésite")
            .description("Cliquez pour ouvrir").subActions(subActionsList).build()

        actions.add(actionYes)
        actions.add(actionNo)
        actions.add(actionDoubt)
    }

    override fun onSubGuidedActionClicked(action: GuidedAction?): Boolean {
        findActionById(2).description = action?.title ?: "missing response"

        val position = findActionPositionById(2)
        notifyActionChanged(position)

        return super.onSubGuidedActionClicked(action)
    }


}
