package com.example.jmora.nuevapracticasqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Jugar extends AppCompatActivity {

    TextView tvPregunta;
    Button btnA1,
            btnA2,
            btnA3,
            btnA4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        tvPregunta = (TextView)findViewById(R.id.tvPregunta);
        btnA1 = (Button)findViewById(R.id.btnA1);
        btnA2 = (Button)findViewById(R.id.btnA2);
        btnA3 = (Button)findViewById(R.id.btnA3);
        btnA4 = (Button)findViewById(R.id.btnA4);

        Dpreguntas dpreguntas = new Dpreguntas(this);
        ArrayList<Epreguntas> listaPreguntas = dpreguntas.getPreguntas();

        if(!listaPreguntas.isEmpty())
        {
            int aleatorio = generarAleatorio(listaPreguntas.size());
            Epreguntas p = listaPreguntas.get(aleatorio);
            tvPregunta.setText(p.getPregunta());
            btnA1.setText(p.getA1());
            btnA2.setText(p.getA2());
            btnA3.setText(p.getA3());
            btnA4.setText(p.getA4());
        }
    }

    public int generarAleatorio(int cantidad)
    {
        return (int)(Math.random()*cantidad);
    }
}
