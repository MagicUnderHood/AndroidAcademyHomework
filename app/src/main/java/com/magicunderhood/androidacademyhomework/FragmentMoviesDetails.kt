package com.magicunderhood.androidacademyhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {

    private var movieDetailsClickListener: MovieDetailsClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.back_text).setOnClickListener {
            movieDetailsClickListener?.onMovieBackPressed()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieDetailsClickListener = context as? MovieDetailsClickListener
    }

    override fun onDetach() {
        super.onDetach()
        movieDetailsClickListener = null
    }

    interface MovieDetailsClickListener {
        fun onMovieBackPressed()
    }
}