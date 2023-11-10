package com.recursos.gestion.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="persona")
@Getter
@Setter
public class Persona implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idpersona;

    @Column(name="nombre_persona",nullable = false,length = 200)
    private String nombre_persona;
    public Persona(){

    }

    public long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(long idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
}
