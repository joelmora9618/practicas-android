package com.example.jmora.practicas1;

/**
 * Created by JMora on 22/12/2016.
 */

public class ClsBasePersona extends ClsAbsPersonas {

    private String nombre;
    private String apellido;
    private int edad;
    private long dni;

    public ClsBasePersona()
    {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String setNombre(String value) {
        return this.nombre = value;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public String setApellido(String value) {
        return this.apellido = value;
    }

    @Override
    public int getEdad() {
        return this.edad;
    }

    @Override
    public int setEdad(int value) {
        return this.edad = value;
    }

    @Override
    public long getDni() {
        return this.dni;
    }

    @Override
    public long setDni(long value) {
        return this.dni = value;
    }
}
