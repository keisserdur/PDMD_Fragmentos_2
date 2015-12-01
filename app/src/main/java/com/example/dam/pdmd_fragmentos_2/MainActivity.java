package com.example.dam.pdmd_fragmentos_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnFragmentoInteraccionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_main);
    }

    @Override
    public void onInteraccion(String dato) {
        Toast.makeText(this, dato, Toast.LENGTH_LONG).show();
        FragmentoDestalle fragmento = (FragmentoDestalle) getFragmentManager().
                findFragmentById(R.id.fragDet);
        if (fragmento == null || !fragmento.isInLayout()) {
            //Vertical
            Intent i=new Intent (this,ActividadMain2Activity.class);
            i.putExtra("datos",dato);
            startActivity(i);
        }else{
            //Horizontal
            fragmento.setDato(dato);
        }
    }
}
