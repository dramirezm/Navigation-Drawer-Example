package bosc.navigationtest.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bosc.navigationtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDos extends android.support.v4.app.Fragment {


    public FragmentDos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_dos, container, false);
    }


}
