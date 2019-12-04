package com.curso.escuela.ApiAFIP;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImpuestosRepository extends JpaRepository<Impuestos,Long>{
	
	
	List<Impuestos> findAllByFechaBetween (Date desde, Date hasta);
	Impuestos findByTipoLike(String tipo);

}
