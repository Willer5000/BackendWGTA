
package com.prtf.wgta.repository;

import com.prtf.wgta.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByEmpresaEx(String empresaEx);
    public boolean existsByEmpresaEx(String empresaEx);
}
