package fr.supinternet.androidtv.ui.browse

import android.os.Bundle
import android.util.Log
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

        prepareEntranceTransition()

        val fragmentAdapter = ArrayObjectAdapter(ListRowPresenter())
        val boxOfficeAdapter = ArrayObjectAdapter(BrowingListPresenter())
        val AttenduAdapter = ArrayObjectAdapter(BrowingListPresenter())

        adapter = fragmentAdapter


        lifecycleScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.IO) {
                val boxOffice = NetworkManager.getBoxOffice()
                boxOffice.forEach { movie ->
                    withContext(Dispatchers.Main) {
                        boxOfficeAdapter.add(movie)
                    }
                }
            }

            withContext(Dispatchers.IO) {
                val anticipatedMovies = NetworkManager.getAnticipatedMovies()
                anticipatedMovies.forEach { movie ->
                    withContext(Dispatchers.Main) {
                        AttenduAdapter.add(movie)
                    }
                }
            }

        }

        fragmentAdapter.add(ListRow(HeaderItem(0, "Les sorties"), boxOfficeAdapter))
        fragmentAdapter.add(ListRow(HeaderItem(0, "Attendus"), AttenduAdapter))
    }
}