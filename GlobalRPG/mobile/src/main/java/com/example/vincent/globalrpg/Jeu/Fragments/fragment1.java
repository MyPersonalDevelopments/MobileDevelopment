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

import com.example.vincent.globalrpg.MainActivity;
import com.example.vincent.globalrpg.R;

/* Créer une interface
Ca permet de faire passer les infos !
 */

public class fragment1 extends Fragment {

    private TextView texteView2;
    private TextView texteView4;
    private TextView texteView6;
    private TextView texteView8;
    private TextView texteView10;


    TextClicked mCallback;

    public interface TextClicked{
        public void sendText(String text);
    }

    public void updateText(String text){
        // Here you have it
    }

    //@Override
    public void onAttach(MainActivity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (TextClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_fragment1, container, true);

        //final Oisillon monstre = new Oisillon();
        //texte3.setText(((Integer)monstre.monstre.initiale.getHp()).toString());

        texteView2 = (TextView) rootView.findViewById( R.id.textView2);
        texteView4 = (TextView) rootView.findViewById( R.id.textView4);
        texteView6 = (TextView) rootView.findViewById( R.id.textView6);
        texteView8 = (TextView) rootView.findViewById( R.id.textView8);
        texteView10 = (TextView) rootView.findViewById( R.id.textView10);

        texteView2.setText("300");
        texteView4.setText("8");
        texteView6.setText("25");
        texteView8.setText("35%");
        texteView10.setText("20%");

        //texteView2.setText(((Integer)mainActivity.personnage.personnage.initiale.getHp()).toString());
        //texteView4.setText(((Integer)mainActivity.personnage.personnage.initiale.getAD()).toString());
        //texteView6.setText(((Integer)mainActivity.personnage.personnage.initiale.getDef()).toString());

        return rootView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }




}
