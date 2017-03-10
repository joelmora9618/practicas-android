package com.example.jmora.juegoconsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by JMora on 29/12/2016.
 */

public class DataBaseManager extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "preguntas";
    public static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        super(context, TABLE_NAME, null, SCHEME_VERSION);
        db = getWritableDatabase();
    }

    public ContentValues generarValores(PreguntasTabla preguntas)
    {
        ContentValues valores = new ContentValues();
        valores.put(PreguntasTabla.FIELD_PREGUNTA,preguntas.getPregunta());
        valores.put(PreguntasTabla.FIELD_OPCION1,preguntas.getOpcion1());
        valores.put(PreguntasTabla.FIELD_OPCION2,preguntas.getOpcion2());
        valores.put(PreguntasTabla.FIELD_OPCION3,preguntas.getOpcion3());
        valores.put(PreguntasTabla.FIELD_OPCION4,preguntas.getOpcion4());
        valores.put(PreguntasTabla.FIELD_ACIERTO,preguntas.getAcierto());
        return valores;
    }

    public void insertarPreguntas(PreguntasTabla preguntas)
    {
        db.insert(PreguntasTabla.TABLE_NAME,null,generarValores(preguntas));
    }

    public ArrayList<PreguntasTabla>getPreguntas()
    {
        ArrayList<PreguntasTabla>listaPreguntas = new ArrayList<>();
        String columnas[] = {PreguntasTabla.FIELD_ID,PreguntasTabla.FIELD_PREGUNTA,PreguntasTabla.FIELD_OPCION1,
                             PreguntasTabla.FIELD_OPCION2,PreguntasTabla.FIELD_OPCION3,PreguntasTabla.FIELD_OPCION4,
                             PreguntasTabla.FIELD_ACIERTO};
        Cursor c = db.query(PreguntasTabla.TABLE_NAME,columnas,null,null,null,null,null,null);

        if(c.moveToFirst())
        {
            do {
                PreguntasTabla p = new PreguntasTabla();
                p.setId(c.getInt(0));
                p.setPregunta(c.getString(1));
                p.setOpcion1(c.getString(2));
                p.setOpcion2(c.getString(3));
                p.setOpcion3(c.getString(4));
                p.setOpcion4(c.getString(5));
                p.setAcierto(c.getString(6));
                listaPreguntas.add(p);
            }while(c.moveToNext());
        }

        return listaPreguntas;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PreguntasTabla.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PreguntasTabla.DROP_TABLE);
        onCreate(db);
    }
}