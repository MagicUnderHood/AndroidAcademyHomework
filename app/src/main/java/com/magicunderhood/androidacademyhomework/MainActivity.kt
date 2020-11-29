package com.magicunderhood.androidacademyhomework

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),
        FragmentMoviesList.MovieClickListener,
        FragmentMoviesDetails.MovieDetailsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

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