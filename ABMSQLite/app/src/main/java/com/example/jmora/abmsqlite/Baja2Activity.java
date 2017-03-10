package com.example.jmora.abmsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmora.abmsqlite.DataBase.DBManager;
import com.example.jmora.abmsqlite.Persona.PersonaBaseClass;

import java.util.ArrayList;

public class Baja2Activity extends AppCompatActivity {

    EditText etBuscar;
    TextView tvNombre,
             tvApellido,
             tvEdad,
             tvDni;
    Button   btnBuscar,
             btnBorrar,
             btnCancelar;
    DBManager helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja2);

        etBuscar = (EditText)findViewById(R.id.etBuscar);
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvApellido = (TextView)findViewById(R.id.tvApellido);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        tvDni = (TextView)findViewById(R.id.tvDni);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);

        helper = new DBManager(this);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.BuscarEmpleado(etBuscar,tvNombre,tvApellido,tvEdad,tvDni);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    helper.EliminarEmpleado(tvNombre.getText().toString());
                    Toast toast = Toast.makeText(Baja2Activity.this,"Empleado eliminado exitosamente",Toast.LENGTH_SHORT);
                    toast.show();

                }catch (Exception e)
                {
                    Toast toast = Toast.makeText(Baja2Activity.this,e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
