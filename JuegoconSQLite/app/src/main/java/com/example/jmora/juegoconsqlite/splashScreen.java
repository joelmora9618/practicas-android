package com.example.jmora.juegoconsqlite;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class splashScreen extends AppCompatActivity {

    private Boolean estado;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        cargarPreferences();
        if(estado)
        {
            Intent intent = new Intent(splashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            ProcesoCargo procesoCargo = new ProcesoCargo();
            procesoCargo.execute();
        }

    }

    public void guardarPreferences(Boolean value)
    {
        SharedPreferences sharPref = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharPref.edit();
        editor.putBoolean("isLoad",value);
        editor.commit();
    }

    public void cargarPreferences()
    {
        SharedPreferences sharPref = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        estado = sharPref.getBoolean("isLoad",false);
    }

    private class ProcesoCargo extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog dialog;
        ArrayList<PreguntasTabla>listaPreguntas = new ArrayList<>(Arrays.asList(
                new PreguntasTabla("Cual es el ide principal de android, Android Studio","otro","otro","otro","otro","otro"),
                new PreguntasTabla("Cual es el mejor tutorial","CodigoFacilito","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Quien es el cantante de ACDC","Brian jhonson","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Cual es el animal mas rapido","Chita","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Cual es el auto mas rapido del mundo","Bugatti bairon","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Cual es el continente mas grande","Asia","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Cual de estos numeros representan el binario","10101","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Que es una funcion","modulo de codigo","Otro","Otro","Otro","Otro"),
                new PreguntasTabla("Cual es la capital de Brasil","Brasilia","Otro","Otro","Otro","Otro")
        ));
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(splashScreen.this);
            dialog.setTitle("Cargando");
            dialog.setMessage("Pensando las preguntas");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            guardarPreferences(true);
            if(dialog.isShowing())
            {
                dialog.dismiss();
                Intent intent = new Intent(splashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            DataBaseManager helper = new DataBaseManager(splashScreen.this);
            for(int i=0;i<listaPreguntas.size();i++)
            {
                PreguntasTabla pregunta = new PreguntasTabla();
                pregunta = listaPreguntas.get(i);
                helper.insertarPreguntas(pregunta);
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
