package com.igenlatam.model.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.igenlatam.model.domain.Producto;
import com.igenlatam.model.exception.ListarException;
import com.igenlatam.model.services.ReportSystem;

@ManagedBean
public class ProductoBean {
	
	private ReportSystem reportSystem;
	private List<Producto> listadoProductos;

	
	public List<Producto> getListadoProductos() {
		return listadoProductos;
	}

	public void setListadoProductos(List<Producto> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}


	//controlar este constructor ---> falta método LISTAR
	public ProductoBean() {
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance()); 
		reportSystem =(ReportSystem)ctx.getBean("myReporteService");
		try {
			listadoProductos = reportSystem.listarProductos();
		} catch (ListarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
