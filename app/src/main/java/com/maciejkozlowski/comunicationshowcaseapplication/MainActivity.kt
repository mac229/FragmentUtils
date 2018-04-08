package com.maciejkozlowski.comunicationshowcaseapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
                .beginTransaction()
                .add(android.R.id.content, MainFragment.newInstance())
                .commit()
    }

    fun showDifferentFragent() {
        // TODO
    }
}
