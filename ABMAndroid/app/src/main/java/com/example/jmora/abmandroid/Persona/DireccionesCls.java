package com.example.jmora.abmandroid.Persona;

/**
 * Created by JMora on 27/12/2016.
 */

public class DireccionesCls {
    private String provincia;
    private String localidad;
    private String calle;

    public DireccionesCls()
    {
        this.provincia = "";
        this.localidad = "";
        this.calle = "";
    }

    public DireccionesCls(String provincia, String localidad, String calle) {
        this.provincia = provincia;
        this.localidad = localidad;
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }


}
