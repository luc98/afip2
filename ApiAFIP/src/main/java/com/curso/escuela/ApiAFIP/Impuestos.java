package com.curso.escuela.ApiAFIP;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Impuestos {
	
	//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name = "usuario", nullable = true)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "fecha")
	private Date fecha;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Usuario: \n" +
                "   id: " + this.id +
                "\n   Tipo : " + this.tipo +
                "\n    Fecha: " + this.fecha;
				
	}
	
	
	
}
