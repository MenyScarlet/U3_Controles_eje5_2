package com.example.didact.u3_controles_eje5;

/**
 * Created by DIDACT on 09/02/2018.
 */

public class Personas {


    //Atributos
    String nombre;
    String apellidos;
    int edad;
    String provincia;
    String estadocivil;


    //Constructor


    public Personas(String nombre, String apellidos, int edad, String provincia, String estadocivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.provincia = provincia;
        this.estadocivil = estadocivil;
    }


    //Getters & Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
}
