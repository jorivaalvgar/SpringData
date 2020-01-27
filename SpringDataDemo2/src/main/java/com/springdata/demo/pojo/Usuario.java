package com.springdata.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	private String tipoId;
	private String identificacion;
	private String nombre;
	
	protected Usuario() {}
	
	public Usuario(String aTipoId, String aNombre, String aIdentificacion) {
		this.setTipoId(aTipoId);
		this.setIdentificacion(aIdentificacion);
		this.setNombre(aNombre);
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Usuario[idUsuario=%d,idTipo=%s, id=%s, Nombre='%s']",
	        getIdUsuario(),getTipoId(), getIdentificacion(), getNombre());
	  }
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoId() {
		return tipoId;
	}
	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
