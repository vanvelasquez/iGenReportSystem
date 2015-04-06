package com.igenlatam.model.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.igenlatam.model.domain.Proyecto;
import com.igenlatam.model.exception.BorrarException;
import com.igenlatam.model.exception.CrearException;
import com.igenlatam.model.exception.ListarException;
import com.igenlatam.model.services.ReportSystem;
import com.igenlatam.model.util.FechaUtil;

@ManagedBean
public class ProyectoBean {
	
	private final String SUCCESS = "pacientesList.xhtml";
	private final String FAILED = "pacientesCreate.xhtml";
	
	private ReportSystem reportSystem;
	private Proyecto proyecto;
	private List<Proyecto> listadoDeProyectos;
	private String fechaPedido;
	
	
	public ProyectoBean() {
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()); //para spring
		reportSystem =(ReportSystem)ctx.getBean("myReporteService");
		proyecto = new Proyecto();
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public List<Proyecto> getListadoDeProyectos() {
		return listadoDeProyectos;
	}


	public void setListadoDeProyectos(List<Proyecto> listadoDeProyectos) {
		this.listadoDeProyectos = listadoDeProyectos;
	}


	public String getFechaPedido() {
		return fechaPedido;
	}


	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	
	/**
	 * Este método llama al método crear de ProyectoBean
	 * para crear un Proyecto
	 * @param proyecto
	 * @return index to navigate to index.xhtml
	 */	
	public String crear(Proyecto proyecto) {
		String resultado;
		if(fechaPedido==""){
			proyecto.setFechaPedido(null);
		}else{
			proyecto.setFechaPedido(FechaUtil.getDate(fechaPedido));}
		
		try {
			System.out.println("Crear proyecto");
			//System.out.println("ID proyecto=" + proyecto.getProyectoId());   es AUTOINCREMENTAL
			System.out.println("ID usuario=" + proyecto.getUsuario().getUsuarioId());
			System.out.println("Fecha Pedido=" + proyecto.getFechaPedido());
			reportSystem.crearProyecto(proyecto);
			resultado = SUCCESS;
			
		} catch (CrearException e) {
			e.printStackTrace();
			resultado = FAILED;
		}
		return resultado;
	}
	

	/**
	 * Este método llama al método editar de ProyectoBean
	 * para editar un Proyecto
	 * @param proyecto
	 * @return index to navigate to index.xhtml
	 */	
	public String editar(Proyecto p) {
		this.proyecto = p;
		String resultado;
		try {
	        System.out.println("Datos antiguos del Paciente = " + proyecto.getProyectoId());
			System.out.println("ID usuario=" + proyecto.getUsuario().getUsuarioId());
			System.out.println("Fecha Pedido=" + proyecto.getFechaPedido());
			reportSystem.editarProyecto(p);
			resultado = "pacientesList.xhtml?faces-redirect=true";
		} catch (Exception e) {
			resultado = FAILED;
		}
		return resultado;
	}
	
		
	/**
	 * Este método llama al método borrar de ProyectoBean
	 * para borrar un Proyecto
	 * @param proyecto
	 * @return index to navigate to index.xhtml
	 */
	public String borrar(Proyecto proyecto) {
		try {
			reportSystem.borrarProyecto(proyecto);
		} catch (BorrarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pacientesList.xhtml?faces-redirect=true";
		
	}
	
	
	/**
	 * Este método lista todos los Proyectos.
	 */
	public void listar() {
		try {
			this.listadoDeProyectos = reportSystem.listarProyectos();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Este método busca un Proyecto por su Id.
	 */
	public void buscar(Long proyectoId) {
		try {
			this.listadoDeProyectos = reportSystem.buscarProyectos(proyectoId);
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
