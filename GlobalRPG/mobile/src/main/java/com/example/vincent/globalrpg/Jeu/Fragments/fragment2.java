package com.example.vincent.globalrpg.Jeu.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vincent.globalrpg.R;

public class fragment2 extends Fragment {

    private TextView texteView2;
    private TextView texteView4;
    private TextView texteView6;
    private TextView texteView8;
    private TextView texteView10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_fragment2, container, true);

        texteView2 = (TextView) rootView.findViewById( R.id.textView2);
        texteView4 = (TextView) rootView.findViewById( R.id.textView4);
        texteView6 = (TextView) rootView.findViewById( R.id.textView6);
        texteView8 = (TextView) rootView.findViewById( R.id.textView8);
        texteView10 = (TextView) rootView.findViewById( R.id.textView10);

        texteView2.setText("50");
        texteView4.setText("35");
        texteView6.setText("5");
        texteView8.setText("20%");
        texteView10.setText("15%");

        return rootView;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
