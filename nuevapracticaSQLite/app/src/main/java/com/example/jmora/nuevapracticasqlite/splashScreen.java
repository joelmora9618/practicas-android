package com.example.jmora.nuevapracticasqlite;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Arrays;

public class splashScreen extends AppCompatActivity {

    private boolean estado;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        cargarRegistro();
        if (estado)
        {
            Intent intent = new Intent(splashScreen.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            procesoCarga cargaPreguntas = new procesoCarga();
            cargaPreguntas.execute();
        }

    }

    private void cargarRegistro()
    {
        SharedPreferences sharPref = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        estado = sharPref.getBoolean("isLoad",false);
    }
    private void guardarRegistro(Boolean valor)
    {
        SharedPreferences sharPref = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharPref.edit();
        editor.putBoolean("isLoad",valor);
        editor.commit();
    }

    private class procesoCarga extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog dialog;
        ArrayList<Epreguntas>listaPreguntas = new ArrayList<>(Arrays.asList(
           new Epreguntas("Cual es el mejor tutorial","CodigoFacilito","Otro","Otro","Otro","Otro"),
           new Epreguntas("Quien es el cantante de ACDC","Brian jhonson","Otro","Otro","Otro","Otro"),
           new Epreguntas("Cual es el animal mas rapido","Chita","Otro","Otro","Otro","Otro"),
           new Epreguntas("Cual es el auto mas rapido del mundo","Bugatti bairon","Otro","Otro","Otro","Otro"),
           new Epreguntas("Cual es el continente mas grande","Asia","Otro","Otro","Otro","Otro"),
           new Epreguntas("Cual de estos numeros representan el binario","10101","Otro","Otro","Otro","Otro"),
           new Epreguntas("Que es una funcion","modulo de codigo","Otro","Otro","Otro","Otro"),
           new Epreguntas("Cual es la capital de Brasil","Brasilia","Otro","Otro","Otro","Otro")
        ));

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(splashScreen.this);
            dialog.setTitle("TITULO");
            dialog.setMessage("CARGANDO PREGUNTAS");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            guardarRegistro(true);
            if(dialog.isShowing())
            {
                dialog.dismiss();
                Intent intent = new Intent(splashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {

            Dpreguntas helper = new Dpreguntas(splashScreen.this);
            for(int i=0; i<listaPreguntas.size();i++)
            {
                Epreguntas preguntas = new Epreguntas();
                preguntas = listaPreguntas.get(i);
                helper.insertarPreguntas(preguntas);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
