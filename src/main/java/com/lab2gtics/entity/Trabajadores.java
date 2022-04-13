package com.lab2gtics.entity;

import javax.persistence.*;

@Entity
@Table(name="trabajadores")
public class Trabajadores {

    @Id
    @Column(name = "dni",nullable = false)
    private String dni;
    @Column(name = "idsede",nullable = false)
    private Integer idsede;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
