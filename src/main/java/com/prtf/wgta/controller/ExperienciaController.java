//OPCION A
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
@CrossOrigin(origins = "https://fedwgta.web.app", allowedHeaders = "*")
//@CrossOrigin(origins = "", allowedHeaders = "")
public class ExperienciaController {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getEmpresaex())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByEmpresaex(dtoexp.getEmpresaex())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = new Experiencia(dtoexp.getEmpresaex(), dtoexp.getDescripcionex(), dtoexp.getLugarex(), dtoexp.getLogoex(), dtoexp.getUrlex(), dtoexp.getCargoex(), dtoexp.getDesdeex(), dtoexp.getHastaex());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Agregada"), HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //Validamos is existe id
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparamos el nombre de la experiencia
        //if (sExperiencia.existsByEmpresaEx(dtoexp.getEmpresaEx()) && sExperiencia.getByEmpresaEx(dtoexp.getEmpresaEx()).get().getId() != id)
        //return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //El campo no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getEmpresaex())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // Validar fecha
        if (dtoexp.getDesdeex() == null || dtoexp.getHastaex() == null) {
            return new ResponseEntity(new Mensaje("La fecha de inicio y fecha final son obligatorias"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getEmpresaex(), dtoexp.getDescripcionex(), dtoexp.getLugarex(), dtoexp.getLogoex(), dtoexp.getUrlex(), dtoexp.getCargoex(), dtoexp.getDesdeex(), dtoexp.getHastaex());
        experiencia.setId(id);
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    /* @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {
        //Validamos is existe id
        if (sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparamos el nombre de la experiencia
        //if (sExperiencia.existsByEmpresaEx(dtoexp.getEmpresaEx()) && sExperiencia.getByEmpresaEx(dtoexp.getEmpresaEx()).get().getId() != id)
        //return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //El campo no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getEmpresaex())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setLogoex(dtoexp.getLogoex());
        experiencia.setUrlex(dtoexp.getUrlex());
        experiencia.setEmpresaex(dtoexp.getEmpresaex());
        experiencia.setDescripcionex(dtoexp.getDescripcionex());
        experiencia.setLugarex(dtoexp.getLugarex());
        experiencia.setCargoex(dtoexp.getCargoex());
        experiencia.setDesdeex(dtoexp.getDesdeex());
        experiencia.setHastaex(dtoexp.getHastaex());

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }*/
   //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
