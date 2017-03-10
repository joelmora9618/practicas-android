package com.example.jmora.practicas1;

/**
 * Created by JMora on 22/12/2016.
 */

public class ClsDireccionesPersonas {

    private String localidad;
    private String calle;

    public ClsDireccionesPersonas()
    {
        this.localidad = "";
        this.calle = "";
    }

    public String getLocalidad()
    {
        return this.localidad;
    }
    public String setLocalidad(String value)
    {
        return this.localidad = value;
    }
    public String getCalle()
    {
        return this.calle;
    }
    public String setCalle(String value)
    {
        return this.calle = value;
    }
}
