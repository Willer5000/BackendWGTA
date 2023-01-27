
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
    private String logoEx;
    private String urlEx;
    private String empresaEx;
    private String descripcionEx;
    private String lugarEx;
    private String cargoEx;
    private String desdeEx;
    private String hastaEx;
//Constructores

    public Experiencia() {
    }

    public Experiencia(String logoEx, String urlEx, String empresaEx, String descripcionEx, String lugarEx, String cargoEx, String desdeEx, String hastaEx) {
        this.logoEx = logoEx;
        this.urlEx = urlEx;
        this.empresaEx = empresaEx;
        this.descripcionEx = descripcionEx;
        this.lugarEx = lugarEx;
        this.cargoEx = cargoEx;
        this.desdeEx = desdeEx;
        this.hastaEx = hastaEx;
    }
// Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoEx() {
        return logoEx;
    }

    public void setLogoEx(String logoEx) {
        this.logoEx = logoEx;
    }

    public String getUrlEx() {
        return urlEx;
    }

    public void setUrlEx(String urlEx) {
        this.urlEx = urlEx;
    }

    public String getEmpresaEx() {
        return empresaEx;
    }

    public void setEmpresaEx(String empresaEx) {
        this.empresaEx = empresaEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }

    public String getLugarEx() {
        return lugarEx;
    }

    public void setLugarEx(String lugarEx) {
        this.lugarEx = lugarEx;
    }

    public String getCargoEx() {
        return cargoEx;
    }

    public void setCargoEx(String cargoEx) {
        this.cargoEx = cargoEx;
    }

    public String getDesdeEx() {
        return desdeEx;
    }

    public void setDesdeEx(String desdeEx) {
        this.desdeEx = desdeEx;
    }

    public String getHastaEx() {
        return hastaEx;
    }

    public void setHastaEx(String hastaEx) {
        this.hastaEx = hastaEx;
    }

}


