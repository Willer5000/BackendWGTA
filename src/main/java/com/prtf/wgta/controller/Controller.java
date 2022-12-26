
package com.prtf.wgta.controller;

import com.prtf.wgta.model.Persona;
import com.prtf.wgta.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {
    //List<Persona>listaPersonas = new ArrayList();
    @Autowired
    private IPersonaService persoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("persona/new/persona")
    //public void agregarPersona(@RequestBody Persona pers){
    public String agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
        //listaPersonas.add(pers);
        return "La persona fue creada correctamente";
    }
    @GetMapping("persona/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        //return listaPersonas;
        return persoServ.verPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("persona/delete/{id}")
    //public void borrarPersona(@PathVariable Long id){
    public String borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
        return "La persona fue eliminada correctamente";
    }
    //URL/puerto
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("persona/edit/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("ocupacion1") String nuevaOcupacion1,
                                 @RequestParam("ocupacion2") String nuevaOcupacion2,
                                 @RequestParam("posgrado") String nuevoPosgrado,
                                 @RequestParam("email") String nuevoEmail,
                                 @RequestParam("sobreMi") String nuevoSobreMi,
                                 @RequestParam("banner") String nuevoBanner,
                                 @RequestParam("img") String nuevoImg){
        Persona pers = persoServ.buscarPersona(id);
        
        pers.setNombre(nuevoNombre);
        pers.setApellido(nuevoApellido);
        pers.setOcupacion1(nuevaOcupacion1);
        pers.setOcupacion2(nuevaOcupacion2);
        pers.setPosgrado(nuevoPosgrado);
        pers.setEmail(nuevoEmail);
        pers.setSobreMi(nuevoSobreMi);
        pers.setBanner(nuevoBanner);
        pers.setImg(nuevoImg);
        
        persoServ.crearPersona(pers);
        return pers;
    }
    @GetMapping("persona/traer/perfil")
    public Persona buscarPersona(){
        return persoServ.buscarPersona((long)1);
    }
    
}
