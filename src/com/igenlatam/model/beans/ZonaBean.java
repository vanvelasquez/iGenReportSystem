package com.igenlatam.model.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.igenlatam.model.domain.Zona;
import com.igenlatam.model.exception.ListarException;
import com.igenlatam.model.services.ReportSystem;

@ManagedBean
public class ZonaBean {
	
	private ReportSystem reportSystem;
	private List<Zona> listadoZonas;


	public List<Zona> getListadoZonas() {
		return listadoZonas;
	}

	public void setListadoZonas(List<Zona> listadoZonas) {
		this.listadoZonas = listadoZonas;
	}


	//controlar este constructor ---> falta método LISTAR
	public ZonaBean() {
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()); 
		reportSystem =(ReportSystem)ctx.getBean("myReporteService");
		try {
			listadoZonas = reportSystem.listarZonas();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
