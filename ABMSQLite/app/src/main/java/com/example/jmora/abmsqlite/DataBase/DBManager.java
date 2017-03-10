package com.example.jmora.abmsqlite.DataBase;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jmora.abmsqlite.Persona.PersonaBaseClass;

import java.util.ArrayList;

/**
 * Created by JMora on 02/01/2017.
 */

public class DBManager extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "empleado";
    public static final int SCHEMA_VERSION = 1;
    SQLiteDatabase db;

    public DBManager(Context context) {
        super(context, TABLE_NAME, null, SCHEMA_VERSION);
        db = getWritableDatabase();
    }

    public ContentValues generarValores(PersonaBaseClass empleado)
    {
        ContentValues values = new ContentValues();
        values.put(TablaPersona.FIELD_DNI, empleado.getDni());
        values.put(TablaPersona.FIELD_NOMBRE, empleado.getNombre());
        values.put(TablaPersona.FIELD_APELLIDO, empleado.getApellido());
        values.put(TablaPersona.FIELD_EDAD, empleado.getEdad());
        return values;
    }

    public void InsertarEmpleado(PersonaBaseClass empleado)
    {
        db.insert(TABLE_NAME,null,generarValores(empleado));
    }
    public void EliminarEmpleado(String nombre)
    {
        db.delete(TABLE_NAME,TablaPersona.FIELD_NOMBRE +"=?", new String[]{nombre});
    }

    public int BuscarEmpleado(EditText etDni, TextView nombre,TextView apellido,TextView edad, TextView dni)
    {
        db = getReadableDatabase();
        String[] argsel = {etDni.getText().toString()};
        String[] proyection = {TablaPersona.FIELD_NOMBRE, TablaPersona.FIELD_APELLIDO,TablaPersona.FIELD_EDAD,TablaPersona.FIELD_DNI};
        Cursor c = db.query(TABLE_NAME,proyection,TablaPersona.FIELD_DNI +"=?",argsel,null,null,null);

        c.moveToFirst();
        nombre.setText(c.getString(0));
        apellido.setText(c.getString(1));
        edad.setText(String.valueOf(c.getInt(2)));
        dni.setText(String.valueOf(c.getInt(3)));
        return c.getPosition();
    }

    public ArrayList<PersonaBaseClass>listaEmpleados()
    {
        ArrayList<PersonaBaseClass>listaEmpleado = new ArrayList<>();
        String columnas[] = {TablaPersona.FIELD_DNI,TablaPersona.FIELD_NOMBRE,TablaPersona.FIELD_APELLIDO,
                             TablaPersona.FIELD_EDAD};
        Cursor c = db.query(TABLE_NAME,columnas,null,null,null,null,null);

       if(c.moveToFirst())
       {
           do {
               PersonaBaseClass persona = new PersonaBaseClass();
               persona.setDni(c.getInt(0));
               persona.setNombre(c.getString(1));
               persona.setApellido(c.getString(2));
               persona.setEdad(c.getInt(3));
               listaEmpleado.add(persona);
           }while(c.moveToNext());
       }
        return listaEmpleado;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaPersona.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TablaPersona.DELETE_TABLE);
        onCreate(db);
    }
}
