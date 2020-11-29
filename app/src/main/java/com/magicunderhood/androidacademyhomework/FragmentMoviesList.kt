package com.magicunderhood.androidacademyhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

/**
 * Фрагмент со списком фильмов
 */
class FragmentMoviesList : Fragment() {

    private var movieClickListener: MovieClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ConstraintLayout>(R.id.movie_card).apply {
            setOnClickListener { movieClickListener?.onDetailsClicked() }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieClickListener = context as? MovieClickListener
    }

    override fun onDetach() {
        super.onDetach()
        movieClickListener = null
    }

    /** Слушатель нажатий в списке фильмов */
    interface MovieClickListener {
        fun onDetailsClicked()
    }
}