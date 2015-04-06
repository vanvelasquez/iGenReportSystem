package com.igenlatam.model.dao;

import java.util.List;

import com.igenlatam.model.domain.Reporte;

public interface ReporteDao {
	
	public List<Reporte> listarReportes();
	public void crearReporte(Reporte reporte);
	public void editarReporte(Reporte reporte);
	public void borrarReporte(Reporte reporte);
	public List<Reporte> buscarReportes(Long reporteId);


}
