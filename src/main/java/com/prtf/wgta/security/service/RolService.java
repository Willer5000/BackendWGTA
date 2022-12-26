
package com.prtf.wgta.security.service;

import com.prtf.wgta.security.entity.Rol;
import com.prtf.wgta.security.enums.RolNombre;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prtf.wgta.security.repository.iRolRepository;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
         return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
      irolRepository.save(rol);
    }
}
