package com.example.jmora.abmandroid.Persona;

/**
 * Created by JMora on 27/12/2016.
 */

public class PersonaBaseCls extends PersonaAbsCls{

    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private ContactoCls contacto;
    private DireccionesCls direcciones;

    public PersonaBaseCls() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = 0;
        contacto = new ContactoCls();
        direcciones = new DireccionesCls();
    }

    public PersonaBaseCls(String nombre, String apellido, int edad, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public String setApellido(String apellido) {
        return this.apellido = apellido;
    }

    @Override
    public int getEdad() {
        return this.edad;
    }

    @Override
    public int setEdad(int edad) {
        return this.edad = edad;
    }

    @Override
    public int getDni() {
        return this.dni;
    }

    @Override
    public int setDni(int dni) {
        return this.dni = dni;
    }
    public ContactoCls getContacto()
    {
        return this.contacto;
    }
    public ContactoCls setContacto(ContactoCls contacto)
    {
        return this.contacto = contacto;
    }
    public DireccionesCls getDirecciones()
    {
        return this.direcciones;
    }
    public DireccionesCls setDirecciones(DireccionesCls direcciones)
    {
        return this.direcciones = direcciones;
    }
}
