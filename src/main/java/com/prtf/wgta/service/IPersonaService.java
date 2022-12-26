
package com.prtf.wgta.service;

import com.prtf.wgta.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Trae la lista de personas
    public List<Persona> verPersonas();
    
    //Guarda una persona al crearla, tambien se pude llamar savePersona
    public void crearPersona (Persona per);
    
    //Elimina una persona
    public void borrarPersona (Long id);
    
    //Buscar una persona por ID
    public Persona buscarPersona (Long id);
    
}
