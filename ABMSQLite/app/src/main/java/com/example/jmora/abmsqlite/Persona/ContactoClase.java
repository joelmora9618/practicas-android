package com.example.jmora.abmsqlite.Persona;

/**
 * Created by JMora on 02/01/2017.
 */

public class ContactoClase {
    private String Telefono1;
    private String Telefono2;
    private String email;

    public ContactoClase()
    {
        this.Telefono1 = "";
        this.Telefono2 = "";
        this.email = "";
    }

    public ContactoClase(String telefono1, String telefono2, String email) {
        Telefono1 = telefono1;
        Telefono2 = telefono2;
        this.email = email;
    }

    public String getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(String telefono1) {
        Telefono1 = telefono1;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(String telefono2) {
        Telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
