package com.example.didact.u3_controles_eje5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellidos, etEdad;
    Spinner spProvincia;
    RadioGroup rgEstadoCivil;
    CheckBox cbTerminos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellidos = (EditText)findViewById(R.id.etApellidos);
        etEdad = (EditText)findViewById(R.id.etEdad);
        spProvincia = (Spinner)findViewById(R.id.spProvincias);
        rgEstadoCivil = (RadioGroup)findViewById(R.id.rgEstadoCivil);
        cbTerminos = (CheckBox)findViewById(R.id.cbTerminos);

        String[] provincias =
                {"Selecciona", "Cádiz", "Sevilla","Huelva","Málaga", "Córdoba","Granada","Jaén", "Almeria"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                R.layout.item_spinner, provincias);
        spProvincia.setAdapter(adaptador);



    }//FIN onCreate



}//FIN MainActivity
