package com.example.dam.pdmd_fragmentos_2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by 2dam on 30/09/2015.
 */
public class Adaptador extends ArrayAdapter<String> {

    private Context contexto;//la actividad que va a contener el listview
    private int recurso;//el layout que se usa para rellenar cada uno de los item del liestview
    private String [] lista;//lista de valores que va a mosrtrar
    private TextView tv,tv2;

    private LayoutInflater i;

    public Adaptador(Context contexto, String[] lista) {
        super(contexto, R.layout.item,lista);

        this.contexto=contexto;
        this.recurso=R.layout.item;
        this.lista=lista;

        //Genera el espacio y lo llena con el layout recurso
        i = (LayoutInflater) contexto.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        //colocamos i en el constructor para ahorrar recursos y lo declaramos de instancia
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.v("ADAPTADOR", "Lamada posicion: " + position);

        //Lo llevamos al constructor para ahorrar recursos
        // LayoutInflater i = (LayoutInflater) contexto.getSystemService
        //        (Context.LAYOUT_INFLATER_SERVICE);

        //Estando mal optimizado
        // convertView = i.inflate(recurso, null);
        ViewHolder vh;
        if (convertView==null){
            Log.v("ADAPTADOR", "Inflando");
            convertView = i.inflate(recurso, null);
            tv = (TextView) convertView.findViewById(R.id.tv_item);
            tv2 = (TextView) convertView.findViewById(R.id.tv2_item);

            vh=new ViewHolder();//Se crea una clase para almacenar cosas
            vh.tv=tv;
            vh.tv2=tv2;
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
            Log.v("ADAPTADOR", "Aprovechando");
        }

        //accedemos a los elementos de layout

        tv.setText(lista[position]);
        tv2.setText("accediendo a posicion "+position);

        //devolver lo generado
        return convertView;

    }

    static class ViewHolder{
        private TextView tv,tv2;
    }

}
