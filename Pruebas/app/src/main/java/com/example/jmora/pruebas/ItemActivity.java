package com.example.jmora.pruebas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ItemActivity extends AppCompatActivity {

    EditText etNombre,
            etApellido,
            etEdad,
            etDni;
    int edadAux,
        position,
        dniAux;
    Button btnModificar,
           btnEliminar;
    ClsContactoPersona persona;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText)findViewById(R.id.etApellido);
        etEdad = (EditText)findViewById(R.id.etEdad);
        etDni = (EditText)findViewById(R.id.etDni);

        btnModificar = (Button)findViewById(R.id.btnModificar);
        btnEliminar = (Button)findViewById(R.id.btnBorrar);

        mainActivity = new MainActivity();

        Intent intent = getIntent();
        Bundle extra = getIntent().getExtras();
        position = extra.getInt("position");
        persona = (ClsContactoPersona) extra.getSerializable("person");

        etNombre.setText(persona.getNombre());
        etApellido.setText(persona.getApellido());
        etEdad.setText(""+persona.getEdad());
        etDni.setText(""+persona.getDni());
    }

    public void btnModificar(View view)
    {
        try
        {
            if (etNombre.getText().toString()!=persona.getNombre()&&etNombre.getText().toString()!="")
            {
                mainActivity.ListaPersonas.get(position).setNombre(etNombre.getText().toString());
                Toast toast = Toast.makeText(ItemActivity.this,"Nombre cambiado exitosamente",Toast.LENGTH_SHORT);
                toast.show();
            }
        }catch (Exception e)
        {
            Toast toast = Toast.makeText(ItemActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
