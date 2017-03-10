package com.example.jmora.abmsqlite.Persona;

/**
 * Created by JMora on 02/01/2017.
 */

public class DireccionClase {
    private String provincia;
    private String localidad;
    private String calle;

    public DireccionClase()
    {
        this.provincia = "";
        this.localidad = "";
        this.calle = "";
    }

    public DireccionClase(String provincia, String localidad, String calle) {
        this.provincia = provincia;
        this.localidad = localidad;
        this.calle = calle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
