package fr.supinternet.androidtv.ui.browse

import android.util.Log
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.Presenter
import fr.supinternet.androidtv.data.network.model.Movie
import kotlin.math.round

class BrowingListPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        return BrowsingListViewHolder(ImageCardView(parent?.context))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        Log.d("CINDY", "je passe ici")
        // On récupère l'objet de la requête
        val movie = item as Movie

        // On récupère le ViewHolder et l'ImageCardView
        val holder = viewHolder as BrowsingListViewHolder
        val img = holder.card

        // TODO Remplir le contenu de la carte à partir de l'objet Movie
        holder.card.titleText = movie.name
        holder.card.contentText = round(movie.rating!!).toString() + "/10"
        holder.loadImage(
            movie.posterURL
                ?: "https://www.publicdomainpictures.net/pictures/280000/velka/not-found-image-15383864787lu.jpg"
        )
    }


    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        // Nous ne l'utiliserons pas
    }


}