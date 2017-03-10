package com.example.jmora.practicas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class AltaPersonaActivity extends AppCompatActivity {

    EditText etNombre,
             etApellido,
             etEdad,
             etDni;
    Button  btnGuardar;
    TextView tvErrorNombre,
             tvErrorApellido,
             tvErrorEdad,
             tvErrorDni,
             tvError;
    boolean bandera = true;
    int edadAux;
    long  dniAux;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_persona);

        final List<ClsContactosPersonas>ListaPersonas = new ArrayList<>();
        final ClsContactosPersonas Persona = new ClsContactosPersonas();

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDni = (EditText)findViewById(R.id.etDni);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        tvErrorNombre = (TextView)findViewById(R.id.tvError1);
        tvErrorApellido = (TextView)findViewById(R.id.tvError2);
        tvErrorEdad = (TextView)findViewById(R.id.tvError3);
        tvErrorDni = (TextView)findViewById(R.id.tvError4);
        tvError = (TextView)findViewById(R.id.tvComplete);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                while(bandera == true)
                {
                    if(etNombre!=null)
                    {
                        Persona.setNombre(etNombre.getText().toString());
                        tvErrorNombre.setVisibility(View.INVISIBLE);
                    }else
                    {
                        tvErrorNombre.setText("Ingrese el nombre");
                        tvErrorNombre.setVisibility(View.VISIBLE);
                        bandera = false;
                    }
                    if(etApellido!=null)
                    {
                        Persona.setApellido(etApellido.getText().toString());
                        tvErrorApellido.setVisibility(View.INVISIBLE);
                    }else
                    {
                        tvErrorApellido.setText("Ingrese el apellido");
                        tvErrorApellido.setVisibility(View.VISIBLE);
                        bandera = false;
                    }
                    if(etEdad!=null)
                    {
                        edadAux = Integer.parseInt(etEdad.getText().toString());
                        Persona.setEdad(edadAux);
                        tvErrorEdad.setVisibility(View.INVISIBLE);
                    }else
                    {
                        tvErrorEdad.setText("ingrese su edad");
                        tvErrorEdad.setVisibility(View.VISIBLE);
                        bandera = false;
                    }
                    if(etDni!=null)
                    {
                        dniAux = Long.parseLong(etDni.getText().toString());
                        Persona.setDni(dniAux);
                        tvError.setVisibility(View.INVISIBLE);
                    }else
                    {
                        tvError.setText("*Debe completar todos los campos");
                        tvError.setVisibility(View.VISIBLE);
                        bandera = false;
                    }
                }

                if(!bandera)
                {
                    try
                    {
                        ListaPersonas.add(Persona);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Usuario Guardado con exito!",Toast.LENGTH_SHORT);
                        Intent intent = new Intent(AltaPersonaActivity.this,MainActivity.class);
                        intent.putExtra("ListaPersonas", (Serializable) ListaPersonas);
                        startActivityForResult(intent,1);
                    }
                    catch (Exception e)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                e.getMessage(),Toast.LENGTH_SHORT);
                    }

                }

            }
        });

    }
}
