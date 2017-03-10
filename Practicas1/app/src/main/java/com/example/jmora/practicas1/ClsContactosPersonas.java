package com.example.jmora.practicas1;

import java.io.Serializable;

/**
 * Created by JMora on 22/12/2016.
 */

public class ClsContactosPersonas extends ClsBasePersona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String telefono1;
    private String telefono2;
    private String email;
    private ClsDireccionesPersonas direcciones;

    public ClsContactosPersonas()
    {
        this.telefono1 = "";
        this.telefono2 = "";
        this.email = "";
        direcciones = new ClsDireccionesPersonas();
        direcciones.setLocalidad("");
        direcciones.setCalle("");
    }

    public String getTelefono1()
    {
        return this.telefono1;
    }
    public String setTelefono1(String value)
    {
        return this.telefono1 = value;
    }
    public String getTelefono2()
    {
        return this.telefono2;
    }
    public String setTelefono2(String value)
    {
        return this.telefono2 = value;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String setEmail(String value)
    {
        return this.email = value;
    }
    public ClsDireccionesPersonas getDirecciones()
    {
        return this.direcciones;
    }
    public ClsDireccionesPersonas setDirecciones(ClsDireccionesPersonas value)
    {
        return this.direcciones = value;
    }
}
