package com.igenlatam.model.domain;

import java.util.Date;

public class Proyecto extends DominioBase{
	private Long proyectoId;
	private String descripcionProyecto;
	private Date fechaPedido;
	private Usuario usuario;
	
	public Long getProyectoId() {
		return proyectoId;
	}
	
	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}
	public Date getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
