package com.prtf.wgta.controller;

import com.prtf.wgta.Dto.dtoExperiencia;
import com.prtf.wgta.model.Experiencia;
import com.prtf.wgta.security.controller.Mensaje;
import com.prtf.wgta.service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://fedwgta.web.app")
public class ExperienciaController {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByEmpresaEx(dtoexp.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexp.getEmpresaEx(), dtoexp.getDescripcionEx(), dtoexp.getLugarEx(), dtoexp.getLogoEx(), dtoexp.getUrlEx(), dtoexp.getCargoEx(), dtoexp.getDesdeEx(), dtoexp.getHastaEx());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //Validamos is existe id
        if (sExperiencia.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //Comparamos el nombre de la experiencia
        if (sExperiencia.existsByEmpresaEx(dtoexp.getEmpresaEx()) && sExperiencia.getByEmpresaEx(dtoexp.getEmpresaEx()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        //El campo no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getEmpresaEx())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setLogoEx(dtoexp.getLogoEx());
        experiencia.setUrlEx(dtoexp.getUrlEx());
        experiencia.setEmpresaEx(dtoexp.getEmpresaEx());
        experiencia.setDescripcionEx(dtoexp.getDescripcionEx());
        experiencia.setLugarEx(dtoexp.getLugarEx());
        experiencia.setCargoEx(dtoexp.getCargoEx());
        experiencia.setDesdeEx(dtoexp.getDesdeEx());
        experiencia.setHastaEx(dtoexp.getHastaEx());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje ("Experiencia actualizada"), HttpStatus.OK);
        
    }
    public ResponseEntity<?> delete(@PathVariable("id")int id){
    if(!sExperiencia.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    sExperiencia.delete(id);
    
    return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
