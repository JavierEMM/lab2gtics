package com.lab2gtics.entity;


import javax.persistence.*;

@Entity
@Table(name="tipos")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo",nullable = false)
    private Integer idtipo;
    @Column(name = "nombre",nullable = false)
    private String nombre;

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
