package com.example.jmora.abmsqlite.Persona;

/**
 * Created by JMora on 02/01/2017.
 */

public class PersonaBaseClass extends PersonaAbsClass {

    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private ContactoClase contacto;
    private DireccionClase direccion;

    public PersonaBaseClass()
    {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = 0;
        contacto = new ContactoClase();
        direccion = new DireccionClase();
    }

    public PersonaBaseClass(String nombre, String apellido, int edad, int dni, ContactoClase contacto, DireccionClase direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.contacto = contacto;
        this.direccion = direccion;
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

    public ContactoClase getContacto()
    {
        return this.contacto;
    }

    public ContactoClase setContacto(ContactoClase contacto)
    {
        return this.contacto = contacto;
    }

    public DireccionClase getDireccion()
    {
        return this.direccion;
    }

    public DireccionClase setDireccion(DireccionClase direccion)
    {
        return this.direccion = direccion;
    }
}
