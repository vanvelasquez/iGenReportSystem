package com.igenlatam.model.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.igenlatam.model.domain.Usuario;
import com.igenlatam.model.exception.BorrarException;
import com.igenlatam.model.exception.CrearException;
import com.igenlatam.model.exception.ListarException;
import com.igenlatam.model.services.ReportSystem;
import com.igenlatam.model.util.FechaUtil;

@ManagedBean
public class UsuarioBean {
	
	private final String SUCCESS = "usuariosMain.xhtml";
	private final String FAILED = "usuariosCreate.xhtml";
	
	private ReportSystem reportSystem;
	private Usuario usuario = new Usuario(); 
	private Long usuarioId;
	private List<Usuario> listadoDeUsuarios = new ArrayList<Usuario>();
	private String fechaNacimiento;
	//de UsuarioFound
	private String nombre;
	private Long dni;
	private String numeroHC;
	private List<Usuario> usuariosEncontrados;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<Usuario> getListadoDeUsuarios() {
		return listadoDeUsuarios;
	}

	public void setListadoDeUsuarios(List<Usuario> listadoDeUsuarios) {
		this.listadoDeUsuarios = listadoDeUsuarios;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	// getters y setters de UsuarioFound
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNumeroHC() {
		return numeroHC;
	}

	public void setNumeroHC(String numeroHC) {
		this.numeroHC = numeroHC;
	}

	public List<Usuario> getUsuariosEncontrados() {
		return usuariosEncontrados;
	}

	public void setUsuariosEncontrados(List<Usuario> usuariosEncontrados) {
		this.usuariosEncontrados = usuariosEncontrados;
	}
	
	
	public UsuarioBean() {
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()); //para spring
		
		reportSystem =(ReportSystem)ctx.getBean("myReporteService");
		//usuario = new Usuario();

		try {
			listadoDeUsuarios = reportSystem.listarUsuarios();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	// listar y prepareEdit estaban en UsuarioList	
	public void listar(){
		try {
			this.listadoDeUsuarios = reportSystem.listarUsuarios();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String prepareEdit(Usuario usuario) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,Object> sessionParams = fc.getExternalContext().getSessionMap();
		sessionParams.put("usuario", usuario);
		return "usuariosEdit.xhtml";
		
	}
	

	/**
	 * Clears the current usuario bean
	 */
	public void clearUsuario() {
		this.usuario = new Usuario();
	}
	
	public String crear() {
		String resultado;
		try {
			System.out.println("Crear usuario");
			System.out.println("Nombre usuario=" + this.usuario.getNombreUsuario());
			reportSystem.crearUsuario(this.usuario);
			resultado = SUCCESS;
			
		} catch (CrearException e) {
			e.printStackTrace();
			resultado = FAILED;
	
		}
		return resultado;
	}
	
	
	/*/esto estaba en UsuarioEdit
	public String editar(Usuario p) {

		this.usuario = p;
		String resultado;
		try {
	        System.out.println("Datos antiguos del Usuario = " + usuario.getUsuarioId());
			System.out.println("N° HC=" + usuario.getNumeroHC());
			System.out.println("DNI=" + usuario.getDni());
			System.out.println("Nombre=" + usuario.getNombre());
			System.out.println("Obra Social=" + usuario.getObraSocial().getNombre());
			reportSystem.editarUsuario(p);
			resultado = "usuariosList.xhtml?faces-redirect=true";
		} catch (Exception e) {
			resultado = "usuariosEdit.xhtml";
		}
		return resultado;
	}
	
	/**
	 * Finds THIS usuario by id.
	 
	public void encontrarUsuarioId() {
		//esto estaba en el constructor
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,Object> sessionParams = fc.getExternalContext().getSessionMap();
		usuario = (Usuario) sessionParams.get("usuario");
		//hasta aqui
		try {
			this.usuario = reportSystem.findUsuarioById(this.usuario.getUsuarioId());
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
	//esto estaba en UsuarioDelete
	public String borrar(Usuario usuario) {
		System.out.println("entró al borrar de UsuarioBean: "+usuario.getNombreUsuario());
		try {
			reportSystem.borrarUsuario(usuario);
		} catch (BorrarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuariosList.xhtml?faces-redirect=true";
		
	}
	
	/*/esto estaba en UsuarioSearch
	public String pasarDatos(String nombre, Long dni, String numeroHC) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,Object> sessionParams = fc.getExternalContext().getSessionMap();
		sessionParams.put("nombre", nombre);
		sessionParams.put("dni", dni);
		sessionParams.put("numeroHC", numeroHC);
		return "usuariosFound.xhtml";
		
	}
	
	
	//esto estaba en UsuarioFound (constructor, no era un método)
	public void encontrar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,Object> sessionParams = fc.getExternalContext().getSessionMap();
		nombre = (String) sessionParams.get("nombre");
		dni = (Long) sessionParams.get("dni");
		numeroHC= (String) sessionParams.get("numeroHC");
		System.out.println("NOMBRE= "+nombre);
		System.out.println("dni= "+dni);
		System.out.println("numeroHC= "+numeroHC);	

		try {
			usuariosEncontrados = reportSystem.buscarUsuarios(nombre,dni,numeroHC);
		} catch (ListarException e) {
			e.printStackTrace();
		}
		
	}*/
}
