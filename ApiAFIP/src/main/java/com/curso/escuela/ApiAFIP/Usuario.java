package com.curso.escuela.ApiAFIP;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.web.bind.annotation.PathVariable;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="clave_fiscal")
	private long clavefiscal; 
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "impuestos_usuario")
	private List<Impuestos> listimp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getClavefiscal() {
		return clavefiscal;
	}

	public void setClavefiscal(long clavefiscal) {
		this.clavefiscal = clavefiscal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Impuestos> getListimp() {
		return listimp;
	}

	public void setListimp(List<Impuestos> listimp) {
		this.listimp = listimp;
	}
	
	
	
	
	
		
}
