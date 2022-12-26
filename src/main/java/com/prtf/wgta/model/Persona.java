
package com.prtf.wgta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //NotNull y Size es de otro manual, eliminar en caso de no compilar, de la misma forma en el POM eliminar Validation
    @NotNull
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String ocupacion1;
    
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String ocupacion2;
    
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String posgrado;
    
    @NotNull
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String email;
    
    @NotNull
    @Size(min = 1, max = 400, message ="No cumple con la longitud")
    private String sobreMi;
    
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String banner;
    
    @Size(min = 1, max = 50, message ="No cumple con la longitud")
    private String img;
    
    public Persona(){
        
    }
    //public Persona(Long id, String nombre, String apellido, String img){
       // this.id = id;
       // this.nombre = nombre;
       // this.apellido = apellido;
        //this.img = img;
    //}
    
}
