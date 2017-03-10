package com.example.jmora.nuevapracticasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by JMora on 28/12/2016.
 */

public class Dpreguntas extends SQLiteOpenHelper{

    public static final String DB_NAME = "preguntas";
    public static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public Dpreguntas(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    public ContentValues generarValores(Epreguntas preguntas)
    {
        ContentValues values = new ContentValues();
        values.put(Epreguntas.FIELD_PREGUNTA,preguntas.getPregunta());
        values.put(Epreguntas.FIELD_A1,preguntas.getA1());
        values.put(Epreguntas.FIELD_A2,preguntas.getA2());
        values.put(Epreguntas.FIELD_A3,preguntas.getA3());
        values.put(Epreguntas.FIELD_A4,preguntas.getA4());
        values.put(Epreguntas.FIELD_AC,preguntas.getAc());
        return values;
    }

    public void insertarPreguntas(Epreguntas preguntas)
    {
        db.insert(Epreguntas.TABLE_NAME,null,generarValores(preguntas));
    }

    public ArrayList<Epreguntas> getPreguntas()
    {
        ArrayList<Epreguntas>listaPreguntas = new ArrayList<>();
        String columnas[] = {Epreguntas.FIELD_ID,Epreguntas.FIELD_PREGUNTA,Epreguntas.FIELD_A1,
                             Epreguntas.FIELD_A2,Epreguntas.FIELD_A3,Epreguntas.FIELD_A4,
                             Epreguntas.FIELD_AC,Epreguntas.FIELD_ESTADO};
        Cursor c = db.query(Epreguntas.TABLE_NAME,columnas,null,null,null,null,null,null);

        if(c.moveToFirst())
        {
            do
            {
                Epreguntas p = new Epreguntas();
                p.setId(c.getInt(0));
                p.setPregunta(c.getString(1));
                p.setA1(c.getString(2));
                p.setA2(c.getString(3));
                p.setA3(c.getString(4));
                p.setA4(c.getString(5));
                p.setAc(c.getString(6));
                p.setEstado(c.getString(7));
                listaPreguntas.add(p);
            }
            while(c.moveToNext());
        }
        return listaPreguntas;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Epreguntas.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ Epreguntas.TABLE_NAME);
        onCreate(db);
    }
}
