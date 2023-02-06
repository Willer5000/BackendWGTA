
package com.prtf.wgta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String logoex;
    private String urlex;
    private String empresaex;
    private String descripcionex;
    private String lugarex;
    private String cargoex;
    private String desdeex;
    private String hastaex;
//Constructores

    public Experiencia() {
    }

    public Experiencia(String logoex, String urlex, String empresaex, String descripcionex, String lugarex, String cargoex, String desdeex, String hastaex) {
        this.logoex = logoex;
        this.urlex = urlex;
        this.empresaex = empresaex;
        this.descripcionex = descripcionex;
        this.lugarex = lugarex;
        this.cargoex = cargoex;
        this.desdeex = desdeex;
        this.hastaex = hastaex;
    }
// Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoex() {
        return logoex;
    }

    public void setLogoex(String logoex) {
        this.logoex = logoex;
    }

    public String getUrlex() {
        return urlex;
    }

    public void setUrlex(String urlex) {
        this.urlex = urlex;
    }

    public String getEmpresaex() {
        return empresaex;
    }

    public void setEmpresaex(String empresaex) {
        this.empresaex = empresaex;
    }

    public String getDescripcionex() {
        return descripcionex;
    }

    public void setDescripcionex(String descripcionex) {
        this.descripcionex = descripcionex;
    }

    public String getLugarex() {
        return lugarex;
    }

    public void setLugarex(String lugarex) {
        this.lugarex = lugarex;
    }

    public String getCargoex() {
        return cargoex;
    }

    public void setCargoex(String cargoex) {
        this.cargoex = cargoex;
    }

    public String getDesdeex() {
        return desdeex;
    }

    public void setDesdeex(String desdeex) {
        this.desdeex = desdeex;
    }

    public String getHastaex() {
        return hastaex;
    }

    public void setHastaex(String hastaex) {
        this.hastaex = hastaex;
    }

    
 
}


