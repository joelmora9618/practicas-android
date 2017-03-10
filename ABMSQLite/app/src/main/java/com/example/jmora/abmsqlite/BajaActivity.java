package com.example.jmora.abmsqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmora.abmsqlite.DataBase.DBManager;
import com.example.jmora.abmsqlite.DataBase.TablaPersona;
import com.example.jmora.abmsqlite.Persona.PersonaBaseClass;

import java.util.ArrayList;

public class BajaActivity extends AppCompatActivity {

    TextView tvNombre,
             tvApellido,
             tvEdad,
             tvDni;
    Button   btnBorrar,
             btnCancelar;
    int position;
    ArrayList<PersonaBaseClass>listaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baja);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvApellido = (TextView)findViewById(R.id.tvApellido);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        tvDni = (TextView)findViewById(R.id.tvDni);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);

        Bundle extra = getIntent().getExtras();
        position = extra.getInt("position");
        final DBManager helper = new DBManager(this);
        listaPersonas = helper.listaEmpleados();

        tvNombre.setText(listaPersonas.get(position).getNombre());
        tvApellido.setText(listaPersonas.get(position).getApellido());
        tvEdad.setText(String.valueOf(listaPersonas.get(position).getEdad()));
        tvDni.setText(String.valueOf(listaPersonas.get(position).getDni()));

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    helper.EliminarEmpleado(listaPersonas.get(position).getNombre());
                    Toast toast = Toast.makeText(BajaActivity.this,"Empleado eliminado exitosamente",Toast.LENGTH_SHORT);
                    toast.show();

                }catch (Exception e)
                {
                    Toast toast = Toast.makeText(BajaActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
