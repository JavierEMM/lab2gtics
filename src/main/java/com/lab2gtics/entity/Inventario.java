package com.lab2gtics.entity;

import javax.persistence.*;

@Entity
@Table(name= "inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinventario", nullable = false )
    private Integer idinventario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "idtipo", nullable = false)
    private Integer idtipo;
    @Column(name = "numeroserie", nullable = false)
    private String numeroserie;
    @Column(name = "idsede", nullable = false)
    private Integer idsede;
    @Column(name = "idmarca", nullable = false)
    private Integer idmarca;
    @Column(name = "estado", nullable = false)
    private String estado;

    public Integer getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

