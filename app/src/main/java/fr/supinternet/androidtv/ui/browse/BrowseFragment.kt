package fr.supinternet.androidtv.ui.browse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import fr.supinternet.androidtv.data.network.NetworkManager
import fr.supinternet.androidtv.data.network.model.Movie
import fr.supinternet.androidtv.ui.main.DetailsActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.Serializable


class BrowseFragment : BrowseSupportFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val fragmentAdapter = ArrayObjectAdapter(ListRowPresenter())
        val boxOfficeAdapter = ArrayObjectAdapter(BrowingListPresenter())
        val anticipatedAdapter = ArrayObjectAdapter(BrowingListPresenter())

        adapter = fragmentAdapter
        prepareEntranceTransition()

        lifecycleScope.launch(Dispatchers.Main) {
            val boxOffice = async(Dispatchers.IO) {
                NetworkManager.getBoxOffice()
            }
            val anticipatedMovies = async(Dispatchers.IO) {
                NetworkManager.getAnticipatedMovies()
            }

            boxOffice.await().forEach { movie ->
                boxOfficeAdapter.add(movie)
            }

            anticipatedMovies.await().apply {
                forEach { movie ->
                    anticipatedAdapter.add(movie)
                }
            }
            startEntranceTransition()
        }
        fragmentAdapter.add(ListRow(HeaderItem(0, "Les sorties"), boxOfficeAdapter))
        fragmentAdapter.add(ListRow(HeaderItem(0, "Attendus"), anticipatedAdapter))

        onItemViewClickedListener =
            OnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
                val movie = item as Movie
                Log.d("TAG", item.toString())
                val intent = Intent(requireContext(), DetailsActivity::class.java)
                intent.putExtra("movieData", movie)
                startActivity(intent)
            }
    }

    override fun setOnItemViewClickedListener(listener: OnItemViewClickedListener?) {
        super.setOnItemViewClickedListener(listener)
    }
}
