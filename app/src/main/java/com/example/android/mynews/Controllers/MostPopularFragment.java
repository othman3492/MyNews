package com.example.android.mynews.Controllers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mynews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends Fragment {


    public MostPopularFragment() {
        // Required empty public constructor
    }


    public static MostPopularFragment newInstance() {

        return new MostPopularFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_most_popular, container, false);
    }

}
