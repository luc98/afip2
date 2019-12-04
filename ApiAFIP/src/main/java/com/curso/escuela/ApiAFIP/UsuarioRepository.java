package com.curso.escuela.ApiAFIP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findAllByClavefiscal(Long clavefiscal);
	// Usuario findByClaveFiscalLike(Long clavefiscal);
	
}
