
package com.prtf.wgta.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String logoEx;
    @NotBlank
    private String empresaEx;
    @NotBlank
    private String descripcionEx;
    @NotBlank
    private String lugarEx;
    @NotBlank
    private String cargoEx;
    @NotBlank
    private String desdeEx;
    @NotBlank
    private String hastaEx;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String logoEx, String empresaEx, String descripcionEx, String lugarEx, String cargoEx, String desdeEx, String hastaEx) {
        this.logoEx = logoEx;
        this.empresaEx = empresaEx;
        this.descripcionEx = descripcionEx;
        this.lugarEx = lugarEx;
        this.cargoEx = cargoEx;
        this.desdeEx = desdeEx;
        this.hastaEx = hastaEx;
    }
    //Getters and Setters

    public String getLogoEx() {
        return logoEx;
    }

    public void setLogoEx(String logoEx) {
        this.logoEx = logoEx;
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
