package com.igenlatam.model.domain;

import java.util.Date;

public class Reporte extends DominioBase{
	private Long reporteId;
	private String localEncuestado;
	private Date fechaInicio;
	private Date fechaFin;
	private Proyecto proyecto;
	
	public Long getReporteId() {
		return reporteId;
	}
	public void setReporteId(Long reporteId) {
		this.reporteId = reporteId;
	}
	
	public String getLocalEncuestado() {
		return localEncuestado;
	}
	public void setLocalEncuestado(String localEncuestado) {
		this.localEncuestado = localEncuestado;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	

}
