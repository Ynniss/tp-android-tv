package fr.supinternet.androidtv.ui.browse

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.lifecycleScope
import fr.supinternet.androidtv.data.network.NetworkManager
import kotlinx.coroutines.*

class BrowseFragment : BrowseSupportFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val fragmentAdapter = ArrayObjectAdapter(ListRowPresenter())
        val boxOfficeAdapter = ArrayObjectAdapter(BrowingListPresenter())
        val anticipatedAdapter = ArrayObjectAdapter(BrowingListPresenter())

        adapter = fragmentAdapter
        prepareEntranceTransition()


        val job = lifecycleScope.launch(Dispatchers.Main) {
            val boxOffice = async(Dispatchers.IO) {
                NetworkManager.getBoxOffice()
            }
            val anticipatedMovies = async(Dispatchers.IO) {
                NetworkManager.getAnticipatedMovies()
            }

            boxOffice.await().forEach { movie ->
                boxOfficeAdapter.add(movie)
            }

            anticipatedMovies.await().forEach { movie ->
                anticipatedAdapter.add(movie)
            }

            startEntranceTransition()
        }


        fragmentAdapter.add(ListRow(HeaderItem(0, "Les sorties"), boxOfficeAdapter))
        fragmentAdapter.add(ListRow(HeaderItem(0, "Attendus"), anticipatedAdapter))
    }
}