package com.igenlatam.model.services;

import java.util.List;
import com.igenlatam.model.domain.Auditor;
import com.igenlatam.model.domain.DetalleReporte;
import com.igenlatam.model.domain.Producto;
import com.igenlatam.model.domain.Proyecto;
import com.igenlatam.model.domain.Reporte;
import com.igenlatam.model.domain.RolUsuario;
import com.igenlatam.model.domain.Usuario;
import com.igenlatam.model.domain.Zona;
import com.igenlatam.model.exception.BorrarException;
import com.igenlatam.model.exception.CrearException;
import com.igenlatam.model.exception.EditarException;
import com.igenlatam.model.exception.ListarException;

public interface ReportSystem {

	//Servicios de USUARIO	
	public List<Usuario> listarUsuarios() throws ListarException;
	public void crearUsuario(Usuario usuario) throws CrearException;
	public void editarUsuario(Usuario usuario) throws EditarException;
	public void borrarUsuario(Usuario usuario) throws BorrarException;
	public List<Usuario> buscarUsuarios(Long usuarioId) throws ListarException;
	
	//Servicios de AUDITOR
	public List<Auditor> listarAuditores() throws ListarException;
	public void crearAuditor(Auditor auditor) throws CrearException;
	public void editarAuditor(Auditor auditor) throws EditarException;
	public void borrarAuditor(Auditor auditor) throws BorrarException;
	public List<Auditor> buscarAuditores(Long auditorId) throws ListarException;	
	
	//Servicios de PROYECTO	
	public List<Proyecto> listarProyectos() throws ListarException;
	public void crearProyecto(Proyecto proyecto) throws CrearException;
	public void editarProyecto(Proyecto proyecto) throws EditarException;
	public void borrarProyecto(Proyecto proyecto) throws BorrarException;
	public List<Proyecto> buscarProyectos(Long proyectoId) throws ListarException;
	
	//Servicios de REPORTE	
	public List<Reporte> listarReportes() throws ListarException;
	public void crearReporte(Reporte reporte) throws CrearException;
	public void editarReporte(Reporte reporte) throws EditarException;
	public void borrarReporte(Reporte reporte) throws BorrarException;
	public List<Reporte> buscarReportes(Long reporteId) throws ListarException;
	
	//Servicios de DETALLE_REPORTE
	public List<DetalleReporte> listarDetallesReporte() throws ListarException;
	public void crearDetalleReporte(DetalleReporte detalleReporte) throws CrearException;
	public void editarDetalleReporte(DetalleReporte detalleReporte) throws EditarException;
	public void borrarDetalleReporte(DetalleReporte detalleReporte) throws BorrarException;
	public List<DetalleReporte> buscarDetallesReporte(Long detalleId) throws ListarException;	
	
	//Servicios auxiliares: ZONA, ROL_USARIO y PRODUCTO
	public List<Zona> listarZonas() throws ListarException;
	public List<RolUsuario> listarRoles() throws ListarException;
	public List<Producto> listarProductos() throws ListarException;
}
