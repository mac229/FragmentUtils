package com.maciejkozlowski.comunicationshowcaseapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Maciej Kozłowski on 07.04.2018.
 */
class MainFragment : Fragment() {
    
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener { onButtonClicked() }
    }

    private fun onButtonClicked() {
        (activity as MainActivity).showDifferentFragent()
    }
}