package com.maciejkozlowski.comunicationshowcaseapplication;

import android.content.Context;

import com.maciejkozlowski.fragmentutils.FragmentUtils;

import androidx.fragment.app.Fragment;

/**
 * Created by Maciej Kozłowski on 09.04.2018.
 */
public class MainFragment extends Fragment {

    private ReplaceFragmentListener replaceFragmentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        replaceFragmentListener = FragmentUtils.getListener(this, ReplaceFragmentListener.class);
    }
}
