package com.igenlatam.model.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.igenlatam.model.domain.RolUsuario;
import com.igenlatam.model.exception.ListarException;
import com.igenlatam.model.services.ReportSystem;

@ManagedBean
public class RolUsuarioBean {
	
	private ReportSystem reportSystem;
	private List<RolUsuario> listadoRoles;

	public List<RolUsuario> getListadoRoles() {
		return listadoRoles;
	}

	public void setListadoRoles(List<RolUsuario> listadoRoles) {
		this.listadoRoles = listadoRoles;
	}


	//controlar este constructor ---> falta método LISTAR
	public RolUsuarioBean() {
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()); 
		reportSystem =(ReportSystem)ctx.getBean("myReporteService");
		try {
			listadoRoles = reportSystem.listarRoles();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
