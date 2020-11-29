package com.magicunderhood.androidacademyhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
        FragmentMoviesList.MovieClickListener,
        FragmentMoviesDetails.MovieDetailsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragments_container, FragmentMoviesList())
                .commit()
    }

    override fun onDetailsClicked() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragments_container, FragmentMoviesDetails())
                .addToBackStack(null)
                .commit()
    }

    override fun onMovieBackPressed() {
        supportFragmentManager.popBackStack()
    }
}