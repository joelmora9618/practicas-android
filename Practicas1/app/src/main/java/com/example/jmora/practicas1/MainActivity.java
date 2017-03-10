package com.example.jmora.practicas1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvPersonas;
    Button btnIngresar,
           btnEliminar,
           btnActualizar;
    List<ClsContactosPersonas>ListaPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPersonas = (ListView)findViewById(R.id.lvPersonas);
        btnIngresar = (Button)findViewById(R.id.btnAlta);
        btnEliminar = (Button)findViewById(R.id.btnBaja);
        btnActualizar = (Button)findViewById(R.id.btnActualizar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AltaPersonaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickAct(View view)
    {
        Bundle extras = getIntent().getExtras();
        ListaPersonas = extras.getParcelable("ListaPersonas");
        ArrayAdapter<ClsContactosPersonas>adaptador = new ArrayAdapter<ClsContactosPersonas>(this,android.R.layout.simple_list_item_1,ListaPersonas);
        lvPersonas.setAdapter(adaptador);
    }
}
