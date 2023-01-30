/*package com.prtf.wgta.controller;

import java.util.List;
import java.util.Optional;

import com.prtf.wgta.model.Experiencia;
import com.prtf.wgta.service.SExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://fedwgta.web.app")
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping
    public List<Experiencia> list() {
        return sExperiencia.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getOne(@PathVariable int id) {
        Optional<Experiencia> experiencia = sExperiencia.getOne(id);
        if (experiencia.isPresent()) {
            return new ResponseEntity<>(experiencia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Experiencia> createExperiencia(@RequestBody Experiencia experiencia) {
        if (!sExperiencia.existsByEmpresaEx(experiencia.getEmpresaEx())) {
            sExperiencia.save(experiencia);
            return new ResponseEntity<>(experiencia, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable int id, @RequestBody Experiencia experiencia) {
        Optional<Experiencia> experienciaActual = sExperiencia.getOne(id);
        if (experienciaActual.isPresent()) {
            experienciaActual.get().setEmpresaEx(experiencia.getEmpresaEx());
            experienciaActual.get().setCargoEx(experiencia.getCargoEx());
            experienciaActual.get().setDescripcionEx(experiencia.getDescripcionEx());
            experienciaActual.get().setDesdeEx(experiencia.getDesdeEx());
            experienciaActual.get().setHastaEx(experiencia.getHastaEx());
            sExperiencia.save(experienciaActual.get());
            return new ResponseEntity<>(experienciaActual.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Experiencia> deleteExperiencia(@PathVariable int id) {
    Optional<Experiencia> experiencia = sExperiencia.getOne(id);
    if (experiencia.isPresent()) {
        sExperiencia.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}*/
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
@RequestMapping("explab/")
@CrossOrigin(origins = "https://fedwgta.web.app")
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

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
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
        if (StringUtils.isBlank(dtoexp.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

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
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
