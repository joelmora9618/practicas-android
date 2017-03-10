package com.example.jmora.abmsqlite.DataBase;

/**
 * Created by JMora on 02/01/2017.
 */

public class TablaPersona {
    //TABLA
    public static final String TABLE_NAME = "empleado";
    public static final String FIELD_DNI = "dni";
    public static final String FIELD_NOMBRE = "nombre";
    public static final String FIELD_APELLIDO = "apellido";
    public static final String FIELD_EDAD = "edad";


    //ACCIONES
    public static final String DELETE_TABLE = "drop table if exists " + TABLE_NAME;
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
                                              FIELD_DNI + " integer primary key," +
                                              FIELD_NOMBRE + " text," +
                                              FIELD_APELLIDO + " text," +
                                              FIELD_EDAD + " integer" +
                                              ");";

}
