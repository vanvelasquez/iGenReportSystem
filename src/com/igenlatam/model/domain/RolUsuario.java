package com.igenlatam.model.domain;

public class RolUsuario extends DominioBase{
	private Long rolUsuarioId;
	private String descripcionRol;
	public Long getRolUsuarioId() {
		return rolUsuarioId;
	}
	public void setRolUsuarioId(Long rolUsuarioId) {
		this.rolUsuarioId = rolUsuarioId;
	}
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	

}
