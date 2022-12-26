
package com.prtf.wgta.service;

import com.prtf.wgta.model.Persona;
import com.prtf.wgta.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    public PersonaRepository persoRepo;
    
//per es persona
    @Override
    public List<Persona> verPersonas() {
        //return persoRepo.findAll();
        List<Persona> per = persoRepo.findAll();
        return per;
    }

    @Override
    public void crearPersona(Persona per) {
       persoRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        //return persoRepo.findById(id).orElse(null);
        Persona per = persoRepo.findById(id).orElse(null);
        return per;
    }
    
}
