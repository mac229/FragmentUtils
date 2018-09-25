package com.maciejkozlowski.comunicationshowcaseapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maciejkozlowski.fragmentutils_kt.getListener
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Maciej Kozłowski on 07.04.2018.
 */
class ExampleFragment : Fragment() {

    private lateinit var action: () -> Unit

    companion object {

        fun newInstance(action: () -> Unit): ExampleFragment {
            val exampleFragment = ExampleFragment()
            exampleFragment.action = action
            return exampleFragment
        }
    }

    private var replaceFragmentListener: ReplaceFragmentListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        replaceFragmentListener = getListener(ReplaceFragmentListener::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener { action() }
    }

    private fun onButtonClicked() {

    }
}