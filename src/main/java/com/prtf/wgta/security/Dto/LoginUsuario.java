
package com.prtf.wgta.security.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUsuario {
    @NotBlank
    private String email;//nombreUsuario
    @NotBlank
    private String password;
    
    //Getter y Setters
}
