package com.igenlatam.model.dao;

import java.util.List;

import com.igenlatam.model.domain.DetalleReporte;

public interface DetalleReporteDao {
	
	public List<DetalleReporte> listarDetalles();
	public void crearDetalle(DetalleReporte detalle);
	public void editarDetalle(DetalleReporte detalle);
	public void borrarDetalle(DetalleReporte detalle);
	public List<DetalleReporte> buscarDetalles(Long detalleId);


}
