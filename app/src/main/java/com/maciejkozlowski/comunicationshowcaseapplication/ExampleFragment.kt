package com.maciejkozlowski.comunicationshowcaseapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maciejkozlowski.fragmentutils_kt.getListenerOrThrowException
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Maciej Kozłowski on 07.04.2018.
 */
class ExampleFragment : Fragment() {

    companion object {

        fun newInstance() = ExampleFragment()
    }

    private lateinit var replaceFragmentListener: ReplaceFragmentListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        replaceFragmentListener = getListenerOrThrowException(ReplaceFragmentListener::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener { onButtonClicked() }
    }

    private fun onButtonClicked() {
        replaceFragmentListener.showMainFragment()
    }
}