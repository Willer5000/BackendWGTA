
package com.prtf.wgta.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String logoex;
    @NotBlank
    private String urlex;
    @NotBlank
    private String empresaex;
    @NotBlank
    private String descripcionex;
    @NotBlank
    private String lugarex;
    @NotBlank
    private String cargoex;
    @NotBlank
    private String desdeex;
    @NotBlank
    private String hastaex;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String logoex, String urlex, String empresaex, String descripcionex, String lugarex, String cargoex, String desdeex, String hastaex) {
        this.logoex = logoex;
        this.empresaex = empresaex;
        this.urlex = urlex;
        this.descripcionex = descripcionex;
        this.lugarex = lugarex;
        this.cargoex = cargoex;
        this.desdeex = desdeex;
        this.hastaex = hastaex;
    }
    //Getters and Setters

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
