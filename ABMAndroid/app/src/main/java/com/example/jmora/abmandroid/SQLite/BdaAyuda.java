package com.example.jmora.abmandroid.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JMora on 27/12/2016.
 */

public class BdaAyuda extends SQLiteOpenHelper {

    Context ctx;
    public BdaAyuda(Context context) {
        super(context, "bs_prueba", null, 1);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table telefono(id_telefo integer primary key autoincrement,numero text not null );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS telefono");
        onCreate(db);
    }

    //variables generales
    BdaAyuda ayuda;
    SQLiteDatabase db;
    //metodos para manejar la BASE de Datos
    public void abrir()
    {
        ayuda = new BdaAyuda(ctx);
        db = ayuda.getWritableDatabase();
    }
    public void cerrar()
    {
        db.close();
    }
    //metodos para manipular datos
    public long registrar(String pNumero) throws Exception
    {
        ContentValues valores = new ContentValues();
        valores.put("numero",pNumero);
        return db.insert("telefono",null,valores);
    }

    public String consultar()throws Exception
    {
        String datos = "";
        String[] columnas = new String[]{"numero"};
        Cursor c = db.query("telefono",columnas,null,null,null,null,null);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            datos += c.getString(c.getColumnIndex("numero"))+"\n";
        }

        return datos;
    }
}
