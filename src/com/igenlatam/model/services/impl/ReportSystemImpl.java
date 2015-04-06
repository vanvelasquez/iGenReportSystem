package com.igenlatam.model.services.impl;

import java.util.List;

import com.igenlatam.model.dao.AuditorDao;
import com.igenlatam.model.dao.DetalleReporteDao;
import com.igenlatam.model.dao.ProductoDao;
import com.igenlatam.model.dao.ProyectoDao;
import com.igenlatam.model.dao.ReporteDao;
import com.igenlatam.model.dao.RolUsuarioDao;
import com.igenlatam.model.dao.UsuarioDao;
import com.igenlatam.model.dao.ZonaDao;

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
import com.igenlatam.model.services.ReportSystem;

public class ReportSystemImpl implements ReportSystem{
	
	private AuditorDao auditorDao;
	private DetalleReporteDao detalleReporteDao;
	private ProductoDao productoDao;
	private ProyectoDao proyectoDao;
	private ReporteDao reporteDao;
	private RolUsuarioDao rolUsuarioDao;
	private UsuarioDao usuarioDao;
	private ZonaDao zonaDao;
	
	public ReportSystemImpl() {
	}

	public AuditorDao getAuditorDao() {
		return auditorDao;
	}

	public void setAuditorDao(AuditorDao auditorDao) {
		this.auditorDao = auditorDao;
	}


	public DetalleReporteDao getDetalleReporteDao() {
		return detalleReporteDao;
	}

	public void setDetalleReporteDao(DetalleReporteDao detalleReporteDao) {
		this.detalleReporteDao = detalleReporteDao;
	}


	public ProductoDao getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDao productoDao) {
		this.productoDao = productoDao;
	}


	public ProyectoDao getProyectoDao() {
		return proyectoDao;
	}

	public void setProyectoDao(ProyectoDao proyectoDao) {
		this.proyectoDao = proyectoDao;
	}


	public ReporteDao getReporteDao() {
		return reporteDao;
	}

	public void setReporteDao(ReporteDao reporteDao) {
		this.reporteDao = reporteDao;
	}


	public RolUsuarioDao getRolUsuarioDao() {
		return rolUsuarioDao;
	}

	public void setRolUsuarioDao(RolUsuarioDao rolUsuarioDao) {
		this.rolUsuarioDao = rolUsuarioDao;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public ZonaDao getZonaDao() {
		return zonaDao;
	}
	
	public void setZonaDao(ZonaDao zonaDao) {
		this.zonaDao = zonaDao;
	}



	//***********************************************************************************
	//*************** IMPLEMENTACIÓN DE SERVICIOS DE USUARIOS ***************************
	@Override
	public List<Usuario> listarUsuarios() throws ListarException {
		List<Usuario> usuariosListado = null;
		try {
			usuariosListado = usuarioDao.listarUsuarios();
			return usuariosListado;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error al Listar Usuarios");
		} 
	}

	@Override
	public void crearUsuario(Usuario usuario) throws CrearException {
		try {
			usuarioDao.crearUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CrearException("Error al crear Usuario");
		}		
	}

	@Override
	public void editarUsuario(Usuario usuario) throws EditarException {
		try {
			usuarioDao.editarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EditarException("Error al editar Usuario");
		}
	}

	@Override
	public void borrarUsuario(Usuario usuario) throws BorrarException {
		try {
			usuarioDao.borrarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BorrarException("Error al borrar Usuario");
		}
	}

	@Override
	public List<Usuario> buscarUsuarios(Long usuarioId) throws ListarException {
		List<Usuario> usuariosBusqueda = null;
		try {
			usuariosBusqueda = usuarioDao.buscarUsuarios(usuarioId);
			return usuariosBusqueda;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error en la búsqueda de Usuarios");
		} 
	}

	//*************** IMPLEMENTACIÓN DE SERVICIOS DE AUDITORES ***************************
	@Override
	public List<Auditor> listarAuditores() throws ListarException {
		List<Auditor> auditoresListado = null;
		try{
			auditoresListado = auditorDao.listarAuditores();
			return auditoresListado;			
		} catch (Exception e){
			e.printStackTrace();
			throw new ListarException("Error al Listar Auditores");
		}
	}

	@Override
	public void crearAuditor(Auditor auditor) throws CrearException {
		try {
			auditorDao.crearAuditor(auditor);;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CrearException("Error al crear Auditor");
		}
	}

	@Override
	public void editarAuditor(Auditor auditor) throws EditarException {
		try {
			auditorDao.editarAuditor(auditor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EditarException("Error al editar Auditor");
		}	
	}

	@Override
	public void borrarAuditor(Auditor auditor) throws BorrarException {
		try {
			auditorDao.borrarAuditor(auditor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BorrarException("Error al borrar Auditor");
		}
	}

	@Override
	public List<Auditor> buscarAuditores(Long auditorId) throws ListarException {
		List<Auditor> auditoresBusqueda = null;
		try {
			auditoresBusqueda = auditorDao.buscarAuditores(auditorId);
			return auditoresBusqueda;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error en la búsqueda de Auditores");
		} 
	}

	//*************** IMPLEMENTACIÓN DE SERVICIOS DE PROYECTOS ***************************
	@Override
	public List<Proyecto> listarProyectos() throws ListarException {
		List<Proyecto> proyectosListado = null;
		try{
			proyectosListado = proyectoDao.listarProyectos();
			return proyectosListado;			
		} catch (Exception e){
			e.printStackTrace();
			throw new ListarException("Error al Listar Proyectos");
		}
	}

	@Override
	public void crearProyecto(Proyecto proyecto) throws CrearException {
		try {
			proyectoDao.crearProyecto(proyecto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CrearException("Error al crear Proyecto");
		}
	}

	@Override
	public void editarProyecto(Proyecto proyecto) throws EditarException {
		try {
			proyectoDao.editarProyecto(proyecto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EditarException("Error al editar Proyecto");
		}
	}

	@Override
	public void borrarProyecto(Proyecto proyecto) throws BorrarException {
		try {
			proyectoDao.borrarProyecto(proyecto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BorrarException("Error al borrar Proyecto");
		}
	}

	@Override
	public List<Proyecto> buscarProyectos(Long proyectoId) throws ListarException {
		List<Proyecto> proyectosBusqueda = null;
		try {
			proyectosBusqueda = proyectoDao.buscarProyectos(proyectoId);
			return proyectosBusqueda;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error en la búsqueda de Proyectos");
		} 
	}

	//*************** IMPLEMENTACIÓN DE SERVICIOS DE REPORTES ***************************
	@Override
	public List<Reporte> listarReportes() throws ListarException {
		List<Reporte> reportesListado = null;
		try{
			reportesListado = reporteDao.listarReportes();
			return reportesListado;			
		} catch (Exception e){
			e.printStackTrace();
			throw new ListarException("Error al Listar Reportes");
		}
	}

	@Override
	public void crearReporte(Reporte reporte) throws CrearException {
		try {
			reporteDao.crearReporte(reporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CrearException("Error al crear Reporte");
		}
	}

	@Override
	public void editarReporte(Reporte reporte) throws EditarException {
		try {
			reporteDao.editarReporte(reporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EditarException("Error al editar Reporte");
		}
	}

	@Override
	public void borrarReporte(Reporte reporte) throws BorrarException {
		try {
			reporteDao.borrarReporte(reporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BorrarException("Error al borrar Reporte");
		}
	}

	@Override
	public List<Reporte> buscarReportes(Long reporteId) throws ListarException {
		List<Reporte> reportesBusqueda = null;
		try {
			reportesBusqueda = reporteDao.buscarReportes(reporteId);
			return reportesBusqueda;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error en la búsqueda de Reportes");
		} 
	}

	//*************** IMPLEMENTACIÓN DE SERVICIOS DE DETALLES-REPORTE ***************************
	@Override
	public List<DetalleReporte> listarDetallesReporte() throws ListarException {
		List<DetalleReporte> detallesReporteListado = null;
		try{
			detallesReporteListado = detalleReporteDao.listarDetalles();
			return detallesReporteListado;			
		} catch (Exception e){
			e.printStackTrace();
			throw new ListarException("Error al Listar Detalles Reporte");
		}
	}

	@Override
	public void crearDetalleReporte(DetalleReporte detalleReporte) throws CrearException {
		try {
			detalleReporteDao.crearDetalle(detalleReporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CrearException("Error al crear Detalle de Reporte");
		}
	}

	@Override
	public void editarDetalleReporte(DetalleReporte detalleReporte) throws EditarException {
		try {
			detalleReporteDao.editarDetalle(detalleReporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EditarException("Error al editar Detalle de Reporte");
		}
	}

	@Override
	public void borrarDetalleReporte(DetalleReporte detalleReporte) throws BorrarException {
		try {
			detalleReporteDao.borrarDetalle(detalleReporte);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BorrarException("Error al borrar Detalle del Reporte");
		}
	}

	@Override
	public List<DetalleReporte> buscarDetallesReporte(Long detalleId) throws ListarException {
		List<DetalleReporte> detallesReporteBusqueda = null;
		try {
			detallesReporteBusqueda = detalleReporteDao.buscarDetalles(detalleId);
			return detallesReporteBusqueda;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error en la búsqueda de Detalles de Reporte");
		} 
	}

	
	//*************** IMPLEMENTACIÓN DE SERVICIOS auxiliares: ZONAS, ROLES, PRODUCTOS **********************
	@Override
	public List<Zona> listarZonas() throws ListarException {
		List<Zona> zonasListado = null;
		try {
			zonasListado = zonaDao.listarZonas();
			return zonasListado;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error al Listar las Zonas");
		} 
	}

	@Override
	public List<RolUsuario> listarRoles() throws ListarException {
		List<RolUsuario> rolesUsuarioListado = null;
		try {
			rolesUsuarioListado = rolUsuarioDao.listarRoles();
			return rolesUsuarioListado;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error al Listar los Roles de Usuario");
		} 
	}

	@Override
	public List<Producto> listarProductos() throws ListarException {
		List<Producto> productosListado = null;
		try {
			productosListado = productoDao.listarProductos();
			return productosListado;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ListarException("Error al Listar los Productos");
		} 
	}


}
