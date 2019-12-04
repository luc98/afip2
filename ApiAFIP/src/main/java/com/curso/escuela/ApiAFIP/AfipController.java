package com.curso.escuela.ApiAFIP;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AfipController {
	@Autowired
	ImpuestosRepository ImpuestoRepo;
	@Autowired
	UsuarioRepository UsuRepo;
	/*
	@GetMapping("/IGanancias/liquidacion/{fecha1}/{fecha2}")
		public List<Impuestos>getFechasLiquidacion(@PathVariable Date fecha1, Date fecha2){
		List<Impuestos> l= Repo.findByDateBetween(fecha1, fecha2);
		return l;
	}
/*	
	@GetMapping("/Impuestos/{clavefiscal}")
		public List<Impuestos>getImpuestosByNmroFiscal(@PathVariable Long clavefiscal){
		
		return Repo.findAllByClaveFiscal(clavefiscal);
	}
	*/
	//1-
	@GetMapping("/afip/impuesto")
	public List<Impuestos> getImpuesto(){
		return ImpuestoRepo.findAll();
		
	}
	@PutMapping("/afip/{id}/{fecha}")
    public Impuestos updateFecha(@PathVariable Long id, @PathVariable Date fecha ) {
        if(ImpuestoRepo.existsById(id)) {
        	Impuestos imp = ImpuestoRepo.findById(id).get();
        	imp.setFecha(fecha);
        	return ImpuestoRepo.save(imp);
        }else {
        	return null;
        }
    	
    }
	
	//2-
	@GetMapping("afip/impuesto/{fecha1}/{fecha2}/")
	public List<Impuestos>getImpuestosByFechas(@PathVariable Date fecha1, @PathVariable Date fecha2){
		List<Impuestos> lista= ImpuestoRepo.findAllByFechaBetween(fecha1, fecha2);
		return lista;
	}
	
	@PostMapping("/afip/usuario/add/{clavefiscal}/{tipo}")
	public ResponseEntity<?> createUsuario(@PathVariable Long clavefiscal, @PathVariable String tipo) {
		Usuario u;
		Impuestos i;
		u = UsuRepo.findAllByClavefiscal(clavefiscal);
		i = ImpuestoRepo.findByTipoLike(tipo);
		u.getListimp().add(i);
			return new ResponseEntity<>(UsuRepo.save(u), HttpStatus.OK);
	}
	/*
	@GetMapping("afip/{clavefiscal}/impuesto)")
	public List<Impuestos> obtenerClaveFiscal(@PathVariable Long clavefiscal){
		
		
		use afip;

INSERT INTO usuario (clave_fiscal,nombre)
VALUES (1,'Lucas'),
(2,' Wilson'),
(3,'Junior'),
(4,'Olaf');



INSERT INTO impuestos (tipo)
values ('Ganancias'),
('sello'),
('valorAgregado'),
('inmuebles'),
('ingresosBrutos');



		
		
		
		
	}
	*/
	
	
}
