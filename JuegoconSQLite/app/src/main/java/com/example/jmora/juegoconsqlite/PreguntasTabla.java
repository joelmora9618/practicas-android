package com.example.jmora.juegoconsqlite;

/**
 * Created by JMora on 29/12/2016.
 */

public class PreguntasTabla {
    public static final String TABLE_NAME = "preguntas";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_PREGUNTA = "pregunta";
    public static final String FIELD_OPCION1 = "opcion1";
    public static final String FIELD_OPCION2 = "opcion2";
    public static final String FIELD_OPCION3 = "opcion3";
    public static final String FIELD_OPCION4 = "opcion4";
    public static final String FIELD_ACIERTO = "acierto";
    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;
    public static final String CREATE_TABLE =  "create table " + TABLE_NAME + "(" +
                                                FIELD_ID + " integer primary key autoincrement," +
                                                FIELD_PREGUNTA + " text," +
                                                FIELD_OPCION1 + " text," +
                                                FIELD_OPCION2 + " text," +
                                                FIELD_OPCION3 + " text," +
                                                FIELD_OPCION4 + " text," +
                                                FIELD_ACIERTO + " integer default 0" +
                                                ");";

    private int id;
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String acierto;

    public PreguntasTabla()
    {
    }

    public PreguntasTabla(String pregunta, String opcion1, String opcion2, String opcion3, String opcion4, String acierto) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.acierto = acierto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getAcierto() {
        return acierto;
    }

    public void setAcierto(String acierto) {
        this.acierto = acierto;
    }
}