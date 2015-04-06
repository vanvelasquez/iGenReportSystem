package com.igenlatam.model.domain;

public class DetalleReporte extends DominioBase {
	private Long detalleReporteId;
	private float pu;
	private boolean presencia;
	private String descripcionDetalle;
	private Producto producto;
	private Reporte reporte;
	
	public Long getDetalleReporteId() {
		return detalleReporteId;
	}
	public void setDetalleReporteId(Long detalleReporteId) {
		this.detalleReporteId = detalleReporteId;
	}
	public float getPu() {
		return pu;
	}
	public void setPu(float pu) {
		this.pu = pu;
	}
	
	public boolean isPresencia() {
		return presencia;
	}
	public void setPresencia(boolean presencia) {
		this.presencia = presencia;
	}
	public String getDescripcionDetalle() {
		return descripcionDetalle;
	}
	public void setDescripcionDetalle(String descripcionDetalle) {
		this.descripcionDetalle = descripcionDetalle;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Reporte getReporte() {
		return reporte;
	}
	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	
}
