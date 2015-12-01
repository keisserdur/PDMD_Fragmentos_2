package com.example.dam.pdmd_fragmentos_2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoListView extends Fragment {

    private String[] str=new String[] {"Casa","Coche","Avion","Portatil","Movil"};
    private View fragView;
    private ListView lv;
    private Adaptador ad;
    private OnFragmentoInteraccionListener listener;

    public FragmentoListView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragView= inflater.inflate(R.layout.fragment_fragmento_list_view, container, false);

        ini();

        return fragView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) context;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof OnFragmentoInteraccionListener){
            listener= (OnFragmentoInteraccionListener) activity;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    private void ini(){
        lv= (ListView) fragView.findViewById(R.id.lvList);
        ad=new Adaptador(this.getActivity(),str);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Ahora lanzamos los tostada desde la actividad
                // Toast.makeText(FragmentoListView.this.getActivity(), "position " + position, Toast.LENGTH_LONG).show();
                listener.onInteraccion(str[position]);
            }
        });
        lv.setAdapter(ad);
    }

}
