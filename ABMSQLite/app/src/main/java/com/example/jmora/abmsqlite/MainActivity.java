package com.example.jmora.abmsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAlta,
           btnBaja,
           btnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlta = (Button)findViewById(R.id.btnAlta);
        btnBaja = (Button)findViewById(R.id.btnBaja);
        btnLista = (Button)findViewById(R.id.btnLista);

        btnAlta.setOnClickListener(this);
        btnBaja.setOnClickListener(this);
        btnLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View args) {
        if(args ==btnAlta)
        {
            Intent intent = new Intent(MainActivity.this, AltaActivity.class);
            startActivity(intent);
        }else if(args == btnBaja)
        {
            Intent intent = new Intent(MainActivity.this, Baja2Activity.class);
            startActivity(intent);
        }else if (args == btnLista)
        {
            Intent intent = new Intent(MainActivity.this, ListaEmpleadosActivity.class);
            startActivity(intent);
        }
    }
}
