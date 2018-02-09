package com.example.didact.u3_controles_eje5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellidos, etEdad;
    Spinner spProvincia;
    RadioGroup rgEstadoCivil;
    CheckBox cbTerminos;
    TextView tvResNombre, tvResApellidos, tvResEdad, tvResProvincia, tvResEstadoCivil;
    ArrayList<Personas> lista_personas = new ArrayList<>();
    int indice;


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
        tvResNombre = (TextView)findViewById(R.id.tvRespNombre);
        tvResApellidos = (TextView)findViewById(R.id.tvRespApellidos);
        tvResEdad = (TextView)findViewById(R.id.tvRespEdad);
        tvResProvincia = (TextView)findViewById(R.id.tvRespProvincia);
        tvResEstadoCivil = (TextView)findViewById(R.id.tvRespEstadoCivil);
        indice = -1;

        String[] provincias =
                {"Selecciona", "Cádiz", "Sevilla","Huelva","Málaga", "Córdoba","Granada","Jaén", "Almeria"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                R.layout.item_spinner, provincias);
        spProvincia.setAdapter(adaptador);



    }//FIN onCreate

    public void clickGuardar (View view){

        boolean checkBoxTerm = cbTerminos.isChecked();

        if (checkBoxTerm){

            String nombre = etNombre.getText().toString();
            String apellidos = etApellidos.getText().toString();
            String edad = etEdad.getText().toString();
            String spinner = spProvincia.getSelectedItem().toString();
            int idEstado = rgEstadoCivil.getCheckedRadioButtonId();


            if (nombre.equals("") || apellidos.equals("") || edad.equals("")
                    || spinner.equals("Selecciona") || idEstado==-1){


                if(nombre.equals("")){
                    tvResNombre.setText("*Este campo es obligatorio");
                    tvResNombre.setBackgroundColor(Color.RED);
                }
                if (apellidos.equals("")){
                    tvResApellidos.setText("*Este campo es obligatorio");
                    tvResApellidos.setBackgroundColor(Color.RED);

                }
                if (edad.equals("")){
                    tvResEdad.setText("*Falta");
                    tvResEdad.setBackgroundColor(Color.RED);
                }
                if (spinner.equals("Selecciona")){
                    tvResProvincia.setText("*Este campo es obligatorio");
                    tvResProvincia.setBackgroundColor(Color.RED);
                }
                if (idEstado==-1){
                    tvResEstadoCivil.setText("*Falta");
                    tvResEstadoCivil.setBackgroundColor(Color.RED);
                }
            }else{

                RadioButton rbCivil = (RadioButton)findViewById(idEstado);
                String estado = rbCivil.getText().toString();
                int edad1 = Integer.parseInt(edad);

limpiarFormulario();
                Personas p = new Personas(nombre, apellidos, edad1, spinner ,estado);
                lista_personas.add(p);
                Toast.makeText(getApplicationContext(), "Persona insertada", Toast.LENGTH_SHORT).show();
                tvResNombre.setText(p.getNombre());
                tvResNombre.setBackgroundColor(Color.TRANSPARENT);
                tvResApellidos.setText(p.getApellidos());
                tvResApellidos.setBackgroundColor(Color.TRANSPARENT);
                tvResEdad.setText(p.getEdad()+"");
                tvResEdad.setBackgroundColor(Color.TRANSPARENT);
                tvResProvincia.setText(p.getProvincia());
                tvResProvincia.setBackgroundColor(Color.TRANSPARENT);
                tvResEstadoCivil.setText(p.getEstadocivil());
                tvResEstadoCivil.setBackgroundColor(Color.TRANSPARENT);



            }

        }else{

            Toast.makeText(getApplicationContext(), "Debes de aceptar los terminos",
                    Toast.LENGTH_LONG).show();

        }


    }

    public void clickDelete (View view){

        limpiarFormulario();

    }

    public void clickBack (View view){

        if (indice>0) {
            indice--;
            cargarPersonas();
        }else{
            indice = 0;
            cargarPersonas();
        }


    }

    public void clickNext (View view){
        if (indice<lista_personas.size()-1) {
            indice++;
            cargarPersonas();
        }else{

            indice = 0;
            cargarPersonas();

        }
    }

    private void cargarPersonas (){

        Personas p = lista_personas.get(indice);
        tvResNombre.setText(p.getNombre());
        tvResNombre.setBackgroundColor(Color.TRANSPARENT);
        tvResApellidos.setText(p.getApellidos());
        tvResApellidos.setBackgroundColor(Color.TRANSPARENT);
       tvResEdad.setText(p.getEdad()+"");
       tvResEdad.setBackgroundColor(Color.TRANSPARENT);
        tvResProvincia.setText(p.getProvincia());
        tvResProvincia.setBackgroundColor(Color.TRANSPARENT);
        tvResEstadoCivil.setText(p.getEstadocivil());
        tvResEstadoCivil.setBackgroundColor(Color.TRANSPARENT);


    }

    private void limpiarFormulario (){

        etNombre.setText("");
        etApellidos.setText("");
        etEdad.setText("");
        rgEstadoCivil.clearCheck();
        spProvincia.setSelection(0);
        cbTerminos.setChecked(false);

    }




}//FIN MainActivity
