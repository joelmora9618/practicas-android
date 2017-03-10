package com.example.jmora.pruebas;

import java.io.Serializable;

/**
 * Created by JMora on 23/12/2016.
 */

public class ClsContactoPersona implements Serializable
{
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;

    public ClsContactoPersona()
    {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = 0;
    }

    public ClsContactoPersona(String nombre, String apellido, int edad, int dni)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre()
    {
        return nombre;
    }
    public String setNombre(String value)
    {
        return this.nombre = value;
    }
    public String getApellido()
    {
        return this.apellido;
    }
    public String setApellido(String value)
    {
        return this.apellido = value;
    }
    public int getEdad()
    {
        return this.edad;
    }
    public int setEdad(int value)
    {
        return this.edad = value;
    }
    public int getDni()
    {
        return this.dni;
    }
    public int setDni(int value)
    {
        return this.dni = value;
    }
}
