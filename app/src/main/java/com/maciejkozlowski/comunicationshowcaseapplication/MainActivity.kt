package com.maciejkozlowski.comunicationshowcaseapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ReplaceFragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(android.R.id.content, ExampleFragment.newInstance())
                    .commit()
        }
    }

    override fun showMainFragment() {
        Toast.makeText(Context@ this, "Show main fragment", Toast.LENGTH_SHORT).show()
    }
}
