package com.example.jmora.abmandroid.Persona;

/**
 * Created by JMora on 27/12/2016.
 */

public class ContactoCls {

    private String telefono1;
    private String telefono2;
    private String email;

    public ContactoCls() {
        this.telefono1 = "";
        this.telefono2 = "";
        this.email = "";
    }

    public ContactoCls(String telefono1, String telefono2, String email) {
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
