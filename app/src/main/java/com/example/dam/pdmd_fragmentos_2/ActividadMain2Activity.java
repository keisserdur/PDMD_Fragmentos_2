package com.example.dam.pdmd_fragmentos_2;

import android.os.Bundle;
import android.app.Activity;

public class ActividadMain2Activity extends Activity {

    private String dato;
    private String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        valor=null;
        if(savedInstanceState!=null){
            valor=savedInstanceState.getString("valor");
        }

        if(valor==null){
            setContentView(R.layout.actividad_main_2);
            dato = getIntent().getExtras().getString("datos");
            FragmentoDestalle fragmento = (FragmentoDestalle) getFragmentManager().
                    findFragmentById(R.id.fragDet);
            fragmento.setDato(dato);
        }else {
            //Regresar el valor a la actividad anterior
            //Con un staractivityForResult
            //Y le pasamos valor
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("valor",dato);
    }
}
