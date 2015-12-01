package com.example.dam.pdmd_fragmentos_2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoDestalle extends Fragment {

    private String dato;
    private View frag;
    private TextView tv;

    public FragmentoDestalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        frag= inflater.inflate(R.layout.fragment_fragmento_destalle, container, false);
        tv= (TextView) frag.findViewById(R.id.tv_frag_detalle);
        return frag;
    }

    public void setDato(String dato){
        this.dato=dato;
        tv.setText(dato);

    }

}
