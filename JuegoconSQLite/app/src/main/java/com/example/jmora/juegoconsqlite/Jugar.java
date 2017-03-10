package com.example.jmora.juegoconsqlite;

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

        DataBaseManager helper = new DataBaseManager(this);
        ArrayList<PreguntasTabla>listaPreguntas = helper.getPreguntas();

        if(!listaPreguntas.isEmpty())
        {
            int aleatorio = numeroAleatorio(listaPreguntas.size());
            PreguntasTabla pregunta = listaPreguntas.get(aleatorio);
            tvPregunta.setText(pregunta.getPregunta());
            btnA1.setText(pregunta.getOpcion1());
            btnA2.setText(pregunta.getOpcion2());
            btnA3.setText(pregunta.getOpcion3());
            btnA4.setText(pregunta.getOpcion4());
        }

    }

    public int numeroAleatorio(int cantidad)
    {
        return (int)(Math.random()*cantidad);
    }
}
